package com.example.library;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Це позначає клас як джерело конфігурації бінів
@Configuration
// Вмикає сканування пакету для пошуку класів з @Component
@ComponentScan(basePackages = "com.example.library")
// Вмикає читання application.properties, що замінює <context:property-placeholder>
@PropertySource("classpath:application.properties")
public class AppConfig {
    // Жодних методів створення бінів (на кшталт @Bean) тут не потрібно,
    // оскільки всі біни визначені через @Component.
}