package com.example.SkillWill300;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private MyComponent myComponent;

    @Autowired
    private String appName;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(greetingService.getGreeting());
        System.out.println(myComponent.sayHello());
        System.out.println("Application name: " + appName);
    }
}