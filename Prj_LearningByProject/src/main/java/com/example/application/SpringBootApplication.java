package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootApplication.class, args);
    }
 
}
