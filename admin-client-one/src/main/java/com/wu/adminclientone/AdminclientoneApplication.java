package com.wu.adminclientone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminclientoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminclientoneApplication.class, args);
    }

}
