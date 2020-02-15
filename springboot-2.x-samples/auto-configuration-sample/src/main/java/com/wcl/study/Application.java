package com.wcl.study;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        Class<?> bootStrapClass = Application.class;
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(bootStrapClass)
                .web(WebApplicationType.NONE)
                .run();
        System.out.println(context.getBean(bootStrapClass));
        context.close();
    }
}
