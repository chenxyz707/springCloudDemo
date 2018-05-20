package com.chenxyz.springCloudDemo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by chenxyz on 2018/5/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    DiscoveryClient discoveryClient;

    public static final String smsInstance = "";

    public String test() {
        final List<ServiceInstance> instances = discoveryClient.getInstances(smsInstance);
        return null;
    }
}
