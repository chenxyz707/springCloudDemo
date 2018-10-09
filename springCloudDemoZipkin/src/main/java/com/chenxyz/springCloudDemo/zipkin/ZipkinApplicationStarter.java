package com.chenxyz.springCloudDemo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * zipkin服务端
 * 收集Sleuth信息
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-10-09
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipkinApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplicationStarter.class, args);
    }
}
