package com.example.mathservice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // Auto Configured Bean
public class MovieBeanLifeCycleTest {

    @Value("Pirates Of Carribeans")
    private String movieName; // 2nd

    public MovieBeanLifeCycleTest() { // 1st
        System.out.println("MovieBeanLifeCycleTest Constructor Invoked. MovieName Is: " + this.movieName);
    }

    @PostConstruct
    private void postConstruct() { // 3rd
        System.out.println("MovieBeanLifeCycleTest postConstruct Invoked. MovieName Is: " + this.movieName);
    }

    @PreDestroy
    private void destruct() { // 5th
        System.out.println("MovieBeanLifeCycleTest preDestroy Invoked!!!");
    }

    public void playMovie() { // 4th
        System.out.println("MovieBeanLifeCycleTest playMovie Invoked!!!");
    }

}
