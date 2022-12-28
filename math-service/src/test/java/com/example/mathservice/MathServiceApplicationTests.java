package com.example.mathservice;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MathServiceApplicationTests {

    @Autowired
    User user;
    @Value("${java.home}")
    private String javaHome;
    @Value("${fruits}")
    private List<String> fruits;
    @Value("/usr/local/chroot")
    private String path;
    @Value("${NON_EXISTING_VARIABLE:DEFAULT_VALUE}")
    private String DEFAULT_VALUE;

    private List<String> valuesList = new ArrayList<>();
    @Autowired
    public void setValues(@Value("#{'${valuesList}'.split(',')}") List<String> values) {
        this.valuesList.addAll(values);
    }
    @Autowired
    private Faker faker;

    @Autowired
    private MovieBeanLifeCycleTest beanLifeCycleTest;

    @Test
    void contextLoads() {
        // Normal Way Of Creating Objects.
        /*
            Address address = new Address();
            Salary salary = new Salary();
            User user = new User(address, salary);
            user.printDetails();
		*/

        // Spring Way To Inject Object.
        user.printDetails();

        System.out.println("Path --> " + path);
        System.out.println("Java Home --> " + javaHome);
        System.out.println("Fruits List --> " + fruits);
        System.out.println("NON_EXISTING_VARIABLE DEFAULT VALUE --> " + DEFAULT_VALUE);

        Assert.isTrue(path.contains("/"), "Path Does Not Contain '/'");
        Assert.isTrue(javaHome.contains("jdk"), "Java Home Property Not Found");
        Assert.isTrue(fruits.size() == 3, "Fruits List Size Is Not Equal To 3.");

        System.out.println("Values List --> "+valuesList);
        System.out.println("Faker Name --> " + faker.name().fullName());
        System.out.println("Faker Company --> " + faker.company().name());
        System.out.println("Faker Dish --> " + faker.food().dish());
    }

    @Test
    void contextLoads2() {
        beanLifeCycleTest.playMovie();
    }
}
