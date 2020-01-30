package com.wcl.study.springframework.annotation;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface StringRepository {

    String value() default "";
}
