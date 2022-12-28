package com.example.mathservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@PropertySource("classpath:values.properties")
public class Salary {
    /*
    // Setting 'amount' Using Constructor. Not Through @Value.
        private int amount;
        public Salary() {
            this.amount = 1000 * ThreadLocalRandom.current().nextInt(1, 10);
        }
    */

    @Value("${amount:1000}") // setting default 'amount' as 1000, if 'amount' property is not set.
    private int amount;


    @Override
    public String toString() {
        return "Salary{" +
                "amount=" + amount +
                '}';
    }

    public int getAmount() {
        return this.amount;
    }
}
