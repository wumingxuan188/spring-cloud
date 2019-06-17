package com.casic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${my.name}")
    String name;
    @RequestMapping("test")
    public String test(){
        return name;
    }
}

