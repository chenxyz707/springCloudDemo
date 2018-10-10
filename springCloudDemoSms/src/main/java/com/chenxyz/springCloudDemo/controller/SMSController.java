package com.chenxyz.springCloudDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chenxyz.springCloudDemo.service.SMSSerivce;

/**
 * Created by chenxyz on 2018/5/25.
 */
@RefreshScope
@RestController
@RequestMapping("sms")
public class SMSController {

    public static final Logger logger = LoggerFactory.getLogger(SMSController.class);

    @Value("${sms.registerMsg}")
    private String registerMsg;

    @Autowired
    private SMSSerivce service;


    @RequestMapping("sendRgister")
    public String sendRegister() {
        logger.info("send sms to registered user");
        return registerMsg;
    }
}
