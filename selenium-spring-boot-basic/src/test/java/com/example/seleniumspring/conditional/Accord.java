package com.example.seleniumspring.conditional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Qualifier("accord")
//@ConditionalOnExpression("${car.speed} > 70") // Replacing It With @Qualifier
public class Accord implements ICar{
    @Override
    public void run() {
        System.err.println("Accord Is Running. Running At Speed: 80mph");
    }
}
