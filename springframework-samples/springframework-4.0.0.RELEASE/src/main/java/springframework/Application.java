package springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    static {
        System.setProperty("java.version", "1.7.0");
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:context.xml");
        context.refresh();
        System.out.println(context.containsBean("first"));
        System.out.println(context.containsBean("second"));
    }
}
