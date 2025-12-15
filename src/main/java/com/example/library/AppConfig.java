package com.example.library;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.EnableAspectJAutoProxy; // НОВИЙ ІМПОРТ

@Configuration
@ComponentScan(basePackages = "com.example.library")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy // УВІМКНЕННЯ AOP
public class AppConfig {
    // ...
}