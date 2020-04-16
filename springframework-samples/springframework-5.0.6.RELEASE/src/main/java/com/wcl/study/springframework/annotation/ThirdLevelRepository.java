package com.wcl.study.springframework.annotation;

@SecondLevelRepository
public @interface ThirdLevelRepository {
    String value() default "";
}
