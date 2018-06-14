package com.chenxyz.springCloudDemo.web.controller.loadBalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxyz on 2018/6/10.
 */
@RestController
@RequestMapping("/loadBalancer/feign")
public class FeignClientController {

    @Autowired
    LoadBalancerClient client;

    @RequestMapping("/eureka/querySMS")
    public String eurekas() {
        ServiceInstance serviceInstance = client.choose("sms-service");
        serviceInstance.getUri();
        return "";
    }

    @RequestMapping("/annotation/querySMS")
    public String annotation() {
        return null;
    }

    @RequestMapping("/properties/querySMS")
    public String properties() {
        return null;
    }
}
