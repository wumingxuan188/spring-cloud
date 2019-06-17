package com.casic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasicApplication.class, args);
    }


    @Value("${properties}")
    private String properties;
    @RequestMapping("test")
    public String test(){
        return properties;
    }
}
