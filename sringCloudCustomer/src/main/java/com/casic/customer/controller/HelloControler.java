package com.casic.customer.controller;

import com.casic.customer.pojo.User;
import com.casic.customer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URI;

@RestController
public class HelloControler {
    @Autowired
    HelloService helloService;

    //负载均衡器
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name)
    {
        return helloService.hiService(name);
    }

    @RequestMapping("testUser")
    public User testUser ()
    {
        return helloService.testUser();
    }
    @RequestMapping("testRibbon")
    public String testRibbon ()
    {
        //获取服务名
        ServiceInstance choose1 = loadBalancerClient.choose("SERVICE-HI");
        //ServiceInstance choose2 = loadBalancerClient.choose("service-ribbon");
       // URI uri = choose1.getUri();
        String host1 = choose1.getHost();
       // String host2 = choose2.getHost();
        Integer port1 = choose1.getPort();
        //Integer port2 = choose2.getPort();

        return  host1+":"+String.valueOf(port1);
    }

}
