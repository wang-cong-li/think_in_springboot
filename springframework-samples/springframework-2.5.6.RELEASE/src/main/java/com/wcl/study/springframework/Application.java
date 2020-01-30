package com.wcl.study.springframework;

import com.wcl.study.springframework.service.BaseService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    static {
        System.setProperty("java.version","1.7.0");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:context.xml");
        context.refresh();


        BaseService baseService = (BaseService) context.getBean("baseService");
        System.out.println(baseService.getBaseInfo());


    }
}
