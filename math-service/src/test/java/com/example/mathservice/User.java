package com.example.mathservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    @Autowired
    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    private Address address;
    private Salary salary;

// Spring Created Object Using This Constructor. (Setter Methods Were Not Created And Not @Autowired.)
//    public User(Address address, Salary salary) {
//        this.address = address;
//        this.salary = salary;
//    }

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", salary=" + salary +
                '}';
    }

    public void printDetails() {
        System.out.println("address street = " + address.getStreet() + " | salary amount = " + salary.getAmount());
    }
}
