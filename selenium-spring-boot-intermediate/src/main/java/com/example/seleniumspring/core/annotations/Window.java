package com.example.seleniumspring.core.annotations;

import java.lang.annotation.*;

@Page
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Window {
    String value() default "";
}
