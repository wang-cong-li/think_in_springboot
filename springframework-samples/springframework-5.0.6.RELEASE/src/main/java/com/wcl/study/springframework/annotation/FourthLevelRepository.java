package com.wcl.study.springframework.annotation;

@SecondLevelRepository
public @interface FourthLevelRepository {
    String value() default "";
}
