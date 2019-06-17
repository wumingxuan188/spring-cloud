package com.casic.customer.service;

import com.casic.customer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name)
    {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }
    public String hiError(String name)
    {

        return "sorry this is error";
    //return restTemplate.getForObject("http://SERVICE-ERROR/hi?name=" + name, String.class);
    }
    public User testUser()
    {
        return restTemplate.getForObject("http://SERVICE-HI/testUser" , User.class);
    }



}
