package com.wcl.study.springframework.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Service
public @interface FirstLevelRepository {

    String value() default "";
}
