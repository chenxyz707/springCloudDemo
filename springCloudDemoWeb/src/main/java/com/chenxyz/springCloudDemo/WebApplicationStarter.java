package com.chenxyz.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by chenxyz on 2018/5/20.
 */
@SpringBootApplication
@EnableEurekaClient
public class WebApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationStarter.class, args);
    }
}
