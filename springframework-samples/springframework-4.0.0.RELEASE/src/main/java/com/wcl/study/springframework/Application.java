package com.wcl.study.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:context.xml");
        context.refresh();
        System.out.println(context.containsBean("first"));  // true
        System.out.println(context.containsBean("second")); // true
        System.out.println(context.containsBean("third"));  // false
    }
}
