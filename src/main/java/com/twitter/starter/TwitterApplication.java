package com.twitter.starter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.twitter.controller")
public class TwitterApplication {


    public static void main(String[] args) {

        SpringApplication.run(TwitterApplication.class, args);

    }

}
