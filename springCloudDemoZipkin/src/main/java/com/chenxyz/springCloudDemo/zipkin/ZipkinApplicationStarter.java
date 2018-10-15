package com.chenxyz.springCloudDemo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

/**
 * zipkin服务端
 * 收集Sleuth信息
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-10-09
 */
@EnableEurekaClient
@EnableZipkinServer  //Http方式传输sleuth信息
//@EnableZipkinStreamServer  //Stream方式传输Sleuth信息
@SpringBootApplication
public class ZipkinApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplicationStarter.class, args);
    }
}
