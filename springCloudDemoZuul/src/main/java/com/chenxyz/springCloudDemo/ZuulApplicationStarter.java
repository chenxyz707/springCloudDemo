package com.chenxyz.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zull启动
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-09-26
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplicationStarter.class, args);
    }
}
