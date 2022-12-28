package com.example.seleniumspring.conditional_test;

import com.example.seleniumspring.base.SpringBaseTestNGTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

/*
For @Bean Or @Component :-
    @ConditionalOnExpression Helps In Injecting Objects Based On Conditions.
    @Qualifier Helps In Injecting Desired Object In Case Of Conflict.
 */
public class CarTests extends SpringBaseTestNGTests {

    @Autowired
    ApplicationContext ctx;

    @Qualifier("accord")
    @Autowired
    ICar car;

    @Test
    public void cartTest1() {
        this.car.run();
    }

    @Test
    public void cartTest2() {
        ICar car1 = this.ctx.getBean(Accord.class); // to get accord bean
        ICar car2 = this.ctx.getBean(Civic.class);  // to get civic bean
        car1.run();
        car2.run();
    }
}
