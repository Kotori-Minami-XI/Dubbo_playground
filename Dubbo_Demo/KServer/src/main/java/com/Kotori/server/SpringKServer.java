package com.Kotori.server;

import com.Kotori.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SpringKServer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-provid.xml");
        context.start();
        System.in.read();
    }
}
