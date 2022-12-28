package com.example.mathservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
    /*
    // Setting 'street' Using Constructor. Not Through @Value.
    private String street;
    public Address() {
        this.street = "10th Floor, 9 Main Street, Solville";
    }
    */

    @Value("${street:10th Floor, 9 Main Street, Solville}")
    private String street;

    @Override
    public String toString() {
        return "Address{" + "street='" + street + '\'' + '}';
    }

    public String getStreet() {
        return this.street;
    }
}
