package com.wcl.study.springframework.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repository
public @interface FirstLevelRepository {

    String value() default "";
}
