package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
@ComponentScan(basePackages={"com.example"})
@PropertySource("classpath:application.properties")
public class StartApp {
    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class , args);
    }
}
