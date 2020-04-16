package com.wcl.study.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:context.xml");
        context.refresh();
        System.out.println(context.containsBean("first"));  // true
        System.out.println(context.containsBean("second")); // true
        System.out.println(context.containsBean("third"));  // false
        System.out.println(context.containsBean("fourth"));
        // 根据实际测试发现，Spring框架最多支持两层的自定义注解派生
        //   --Component                 #spring原生注解     ok
        //     |--Service                #spring原生注解     ok
        //        |--FirstLevel          #自定义第一层注解    ok
        //           |--SecondLevel      #自定义第二层注解    ok
        //              |--ThirdLevel    #自定义第三层注解    not ok
    }
}
