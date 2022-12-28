package com.example.seleniumspring.core.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Bean
@Documented
@Scope("browserscope")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ThreadScopeBean {
}
