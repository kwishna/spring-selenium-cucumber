package com.example.mathservice.configs;

import com.example.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.util.List;

// Manually Configured Of Bean
@Configuration // Marks The Class As Source Of Bean. This Class Will Return Bean
@ComponentScan(basePackages = {"com.example.component", "com.example.controller", "com.example.service"})
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.baeldung\\.componentscan\\.springapp\\.flowers\\..*"))
//@ComponentScan
public class AppConfig {
    // Configuration classes can contain bean definition methods annotated with @Bean:
    @Bean("student1") // Manually Configured Of Bean
    public Employee getEmployee1() {
        System.out.println("Employee Initialized!");
        return new Employee("DJ", "Engg.");
    }

    @Bean("student2")
    public Employee getEmployee2() {
        System.out.println("Employee Initialized!");
        return new Employee("DJ2", "Engg2.");
    }

    /*
        We Would Like To Get A List<String> Autowired With Hard Coded Values - "A", "B", "C" In Our Test Class. What Should We Do??
        We Need A Manual Configured Bean. So We Have To Use @Bean As Shown Here.
     */
    @Bean
    public List<String> list() {
        return List.of("a", "b", "c");
    }
}