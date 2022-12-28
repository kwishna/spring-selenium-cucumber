package com.example.seleniumspring.conditional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Qualifier("civic")
//@ConditionalOnExpression("${car.speed} < 70")
public class Civic implements ICar {
    @Override
    public void run() {
        System.err.println("Civic Is Running. Running At Speed: 60mph");
    }
}
