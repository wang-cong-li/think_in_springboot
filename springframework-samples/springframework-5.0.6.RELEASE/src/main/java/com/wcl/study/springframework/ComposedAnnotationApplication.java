package com.wcl.study.springframework;

import com.wcl.study.springframework.service.impl.ComposedAnnotationServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;
import java.util.Set;

public class ComposedAnnotationApplication {

    /**
     * spring组合注解解析
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        MetadataReader metadataReader = new SimpleMetadataReaderFactory().getMetadataReader(ComposedAnnotationServiceImpl.class.getName());
        AnnotationMetadata  annotationMetadata = metadataReader.getAnnotationMetadata();
        for (String annotationType : annotationMetadata.getAnnotationTypes()) {  // 获取直接标注在class上的注解，本例子中，ComposedAnnotationServiceImpl上直接标注的注解只有"@TransactionalService"
            Set<String> metadataAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType); // 获取标注在class注解上的注解的注解（递归获取所有的注解信息）
            for (String metadataAnnotationTypeName: metadataAnnotationTypes) {
                System.out.printf("注解 @%s 元标注注解 @%s \n", annotationType, metadataAnnotationTypeName);
            }
        }

        /**
         * 注解 @com.wcl.study.springframework.composed_annotation.TransactionalService 元标注注解 @org.springframework.transaction.annotation.Transactional
         * 注解 @com.wcl.study.springframework.composed_annotation.TransactionalService 元标注注解 @org.springframework.stereotype.Service
         * 注解 @com.wcl.study.springframework.composed_annotation.TransactionalService 元标注注解 @org.springframework.stereotype.Component
         * 注解 @com.wcl.study.springframework.composed_annotation.TransactionalService 元标注注解 @org.springframework.stereotype.Indexed
         */

    }
}