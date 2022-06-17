package com.xproject.master.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "com.xproject")
public class MasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterApplication.class, args);
    }

}
