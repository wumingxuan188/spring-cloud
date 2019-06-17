package com.casic.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloControler {

    //负载均衡器
    @Resource
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping("testRibbon")
    public String testRibbon ()
    {
        //获取服务名
        ServiceInstance choose1 = loadBalancerClient.choose("stores");
        //ServiceInstance choose2 = loadBalancerClient.choose("service-ribbon");
       // URI uri = choose1.getUri();
        String host1 = choose1.getHost();
       // String host2 = choose2.getHost();
        Integer port1 = choose1.getPort();
        //Integer port2 = choose2.getPort();

        return  host1+":"+String.valueOf(port1);
    }

}
