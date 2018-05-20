package com.chenxyz.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by chenxyz on 2018/5/20.
 */
@SpringBootApplication
@EnableEurekaClient
public class SMSApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(SMSApplicationStarter.class, args);
    }
}
