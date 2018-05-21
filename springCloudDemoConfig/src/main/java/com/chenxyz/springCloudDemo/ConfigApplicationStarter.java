package com.chenxyz.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-05-21
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplicationStarter.class, args);
    }
}
