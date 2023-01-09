package com.example.seleniumspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

//@SpringBootApplication(exclude = MongoAutoConfiguration.class)
// Extent Report Contains Mongo Library Which Makes Spring Start Auto-Configuring It. So, We Need To Exclude It.
@SpringBootApplication
public class SeleniumSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeleniumSpringBootApplication.class, args);
    }

}
