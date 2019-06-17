package com.demo.service;

import org.springframework.stereotype.Component;

/**
 * 出错后的访问地址
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry,it's error"+name;
    }

    @Override
    public String sayTest(String name) {
        return null;
    }
}
