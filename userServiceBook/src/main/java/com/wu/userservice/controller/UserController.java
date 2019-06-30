package com.wu.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("hi")
    public String hi(){
        return "i am Wumx";
    }
    @RequestMapping("/call")
    public String callHome(){
        //logger.log(Level.INFO, "calling trace service-hi  ");
        return restTemplate.getForObject("http://localhost:8988/hi", String.class);
    }
}
