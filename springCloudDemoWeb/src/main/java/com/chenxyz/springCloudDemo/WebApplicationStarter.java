package com.chenxyz.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;

/**
 * Created by chenxyz on 2018/5/20.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(defaultConfiguration = FeignClientsConfiguration.class)
@EnableCircuitBreaker
public class WebApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationStarter.class, args);
    }
}
