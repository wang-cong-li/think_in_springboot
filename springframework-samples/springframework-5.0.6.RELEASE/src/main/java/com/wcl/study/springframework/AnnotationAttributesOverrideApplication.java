package com.wcl.study.springframework;

import com.wcl.study.springframework.composed_annotation.TransactionalService;
import com.wcl.study.springframework.service.impl.ComposedAnnotationServiceImpl;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Set;

public class AnnotationAttributesOverrideApplication {

    /**
     * spring组合注解解析
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        AnnotatedElement annotatedElement = ComposedAnnotationServiceImpl.class;
        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
        System.out.println("transactionalService.name() result is: " + transactionalService.name());
        // transactionalService.name() result is: composed
        ReflectionUtils.doWithMethods(TransactionalService.class, method -> {
            System.out.printf("@TransactionalService.%s() = %s \n", method.getName(), ReflectionUtils.invokeMethod(method,transactionalService));
        }, method -> { return method.getParameterCount() == 0;});
        /**
         * @TransactionalService.name() = composed
         * @TransactionalService.toString() = @com.wcl.study.springframework.composed_annotation.TransactionalService(name=composed)
         * @TransactionalService.hashCode() = -976286745
         * @TransactionalService.annotationType() = interface com.wcl.study.springframework.composed_annotation.TransactionalService
         */
        System.out.println("*******************************************");
        ReflectionUtils.doWithMethods(TransactionalService.class, method -> {
            System.out.printf("@TransactionalService.%s() = %s \n", method.getName(), ReflectionUtils.invokeMethod(method,transactionalService));
        }, method -> !(method.getDeclaringClass().equals(Annotation.class)));
        /**
         * @TransactionalService.name() = composed
         */
    }
}