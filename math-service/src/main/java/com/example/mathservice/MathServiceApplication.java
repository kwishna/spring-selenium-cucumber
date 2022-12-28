package com.example.mathservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
@Configuration
@EnableAutoConfiguration
@ComponentScan
 */
@SpringBootApplication
public class MathServiceApplication {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(MathServiceApplication.class, args);
		checkBeansPresence("cat", "dog", "rose", "exampleBean", "springBootComponentScanApp");
	}

	private static void checkBeansPresence(String... beans) {
		for (String beanName : beans) {
			System.out.println("Is " + beanName + " in ApplicationContext: " + applicationContext.containsBean(beanName));
		}
	}

}
