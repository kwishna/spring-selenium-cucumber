package com.example.seleniumspring.conditional;

import com.example.seleniumspring.SpringBaseTestNGTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

/*
For @Bean Or @Component :-
    @ConditionalOnExpression Helps In Injecting Objects Based On Conditions.
    @Qualifier Helps In Injecting Desired Object In Case Of Conflict.
 */
public class CarTests extends SpringBaseTestNGTests {

    @Qualifier("accord")
    @Autowired
    ICar car;

    @Test
    public void cartTest() {
        this.car.run();
    }
}
