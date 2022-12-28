package com.example.seleniumspring.core.annotations;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Lazy
@Component
@Documented
//@Scope("prototype")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface PageFragment {
}
