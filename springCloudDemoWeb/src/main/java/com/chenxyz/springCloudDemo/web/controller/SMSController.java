package com.chenxyz.springCloudDemo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by chenxyz on 2018/5/20.
 */
@Controller
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    public static final String SMS_INSTANCE = "sms-service";
    public static final String SMS_PATH = "/sms";

    @RequestMapping("send")
    @ResponseBody
    public String send() {
        List<ServiceInstance> instances = discoveryClient.getInstances(SMS_INSTANCE);
        return null;
    }

    @RequestMapping("getSMSById")
    @ResponseBody
    public String getSMSById(String id) {
        List<ServiceInstance> instances = discoveryClient.getInstances(SMS_INSTANCE);
        ServiceInstance instance = instances.get(0);
        String url = "http://"+instance.getHost()+":"+instance.getPort()+SMS_PATH+"/"+id;

        return restTemplate.getForObject(url, String.class);
    }
}
