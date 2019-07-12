package com.wu.adminclienttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminclienttwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminclienttwoApplication.class, args);
    }

}
