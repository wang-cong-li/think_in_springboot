package com.wcl.study.springframework.annotation;

@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}
