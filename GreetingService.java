package com.example.SkillWill300;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting() {
        return "Hello! This is a Spring Boot @Service.";
    }
}
