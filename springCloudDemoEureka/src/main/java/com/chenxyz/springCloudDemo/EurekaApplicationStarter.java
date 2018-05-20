package com.chenxyz.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by chenxyz on 2018/5/20.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationStarter.class, args);
    }
}
