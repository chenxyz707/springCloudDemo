package com.chenxyz.springCloudDemo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 用户服务启动类
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-07-02
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(UserApplicationStarter.class, args);
    }
}
