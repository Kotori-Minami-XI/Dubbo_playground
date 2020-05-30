package com.Kotori.client;

import com.Kotori.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringKClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-consumer.xml");
        context.start();
        UserService service = (UserService) context.getBean("userService");
        service.doSomething();
    }
}
