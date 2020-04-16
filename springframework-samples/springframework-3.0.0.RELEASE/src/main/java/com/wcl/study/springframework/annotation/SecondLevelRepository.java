package com.wcl.study.springframework.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}
