package com.wcl.study.springframework.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SecondLevelRepository
public @interface FourthLevelRepository {
    String value() default "";
}
