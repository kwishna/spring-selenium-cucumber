package com.example.seleniumspring.core.configs;

import com.example.seleniumspring.core.annotations.LazyConfiguration;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@LazyConfiguration
@PropertySource(value = "classpath:selenium.properties", ignoreResourceNotFound = true)
@ComponentScan(basePackages = {"com.example.pages", "com.example.seleniumspring"})
public class AppConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
