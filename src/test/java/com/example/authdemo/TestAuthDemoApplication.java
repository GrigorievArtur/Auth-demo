package com.example.authdemo;

import org.springframework.boot.SpringApplication;

public class TestAuthDemoApplication {

    public static void main(String[] args) {
        SpringApplication.from(AuthDemoApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
