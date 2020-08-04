package com.rover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.rover.service")
public class MyAppTests {

    public static void main(String[] args) {
        SpringApplication.run(MyAppTests.class, args);
    }
}