package com.chenxyz.springCloudDemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxyz on 2018/5/25.
 */
@RefreshScope
@RestController
@RequestMapping("sms")
public class SMSController {

    @Value("${sms.registerMsg}")
    private String registerMsg;

    @RequestMapping("sendRgister")
    public String sendRegister() {
        return registerMsg;
    }
}
