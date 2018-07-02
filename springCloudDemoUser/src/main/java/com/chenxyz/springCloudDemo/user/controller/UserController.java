package com.chenxyz.springCloudDemo.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/timeout")
    public String timeout() throws InterruptedException {
        LOGGER.info("invoking timeout endpoint");
        Thread.sleep(10000L);
        return "success";
    }

    @RequestMapping("/exception")
    public String exception() {
        LOGGER.info("invoking exception endpoint");
        if (System.currentTimeMillis() % 2 == 0) {
            throw new RuntimeException("random exception");
        }
        return "success";
    }
}
