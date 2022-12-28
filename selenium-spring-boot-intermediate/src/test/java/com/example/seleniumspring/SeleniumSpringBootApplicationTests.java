package com.example.seleniumspring;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

// It Is A Junit Test.
@SpringBootTest
class SeleniumSpringBootApplicationTests {

    @Value("${java.home}")
    private String javaHome;

    @Autowired
    private Faker faker;

    @Test
    void contextLoads() {
        System.out.println("Faker lorem: " + faker.lorem().words(10));
    }
}
