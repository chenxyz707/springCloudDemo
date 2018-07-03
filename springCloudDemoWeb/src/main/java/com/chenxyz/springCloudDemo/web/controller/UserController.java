package com.chenxyz.springCloudDemo.web.controller;

import com.chenxyz.springCloudDemo.web.command.UserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by chenxyz on 2018/5/20.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/timeout")
    public String timeout() {
        //This instance can only be executed once. Please instantiate a new instance.
        return new UserCommand().execute();
    }
}
