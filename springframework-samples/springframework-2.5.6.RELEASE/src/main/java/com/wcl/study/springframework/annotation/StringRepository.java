package com.wcl.study.springframework.annotation;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Repository         // spring2.5不支持注解派生特性，使用这个注解将导致StringRepository不能被扫描为Spring Bean
@Component
public @interface StringRepository {

    String value() default "";
}
