package com.wcl.study.springframework;


import com.wcl.study.springframework.composed_annotation.TransactionalService;
import com.wcl.study.springframework.service.impl.ComposedAnnotationServiceImpl;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 纯java反射实现的读取一个注解上的所有的元注解信息（排除java.lang.annotaion包的注解属性）
 */
public class TranscationalServiceAnnotationRecurselyReflectionBootstrap {

    public static void main(String[] args) {
        AnnotatedElement annotatedElement = ComposedAnnotationServiceImpl.class;
        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
        Set<Annotation> allAnnotationSet = getAllAnnotation(transactionalService);
        allAnnotationSet.forEach(TranscationalServiceAnnotationRecurselyReflectionBootstrap::printAnnotationAttributes);
    }

    private static Set<Annotation> getAllAnnotation(Annotation annotation) {
        Annotation[] annotations = annotation.annotationType().getAnnotations();
        if (ObjectUtils.isEmpty(annotations)) {
            return Collections.emptySet();
        }
        Set<Annotation> metaAnnotationSet = Stream.of(annotations)
                .filter(metaAnnotation-> !Target.class.getPackage().equals(metaAnnotation.annotationType().getPackage()))
                .collect(Collectors.toSet());
        Set<Annotation> metaMetaAnnotationSet = metaAnnotationSet.stream()
                .map(TranscationalServiceAnnotationRecurselyReflectionBootstrap::getAllAnnotation)
                .collect(HashSet::new, Set::addAll,Set::addAll);
        metaAnnotationSet.addAll(metaMetaAnnotationSet);
        return metaAnnotationSet;
    }

    public static void printAnnotationAttributes(Annotation annotation) {
        Class annotationType = annotation.annotationType();
        ReflectionUtils.doWithMethods(annotationType,method -> {
            try {
                if (0 == method.getParameterCount()) {
                    System.out.println(annotationType.getName() + "." + method.getName() + "=\t"
                            + ReflectionUtils.invokeMethod(method, annotation));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, method -> !method.getDeclaringClass().equals(Annotation.class));
    }


}
