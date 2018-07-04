package com.chenxyz.springCloudDemo.web.controller;

import com.chenxyz.springCloudDemo.web.command.UserExceptionCommand;
import com.chenxyz.springCloudDemo.web.command.UserAnnotationCommand;
import com.chenxyz.springCloudDemo.web.command.UserTimeOutCommand;
import com.chenxyz.springCloudDemo.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxyz on 2018/5/20.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserAnnotationCommand userAnnotationCommand;

    @RequestMapping("/command/timeout")
    public String commandTimeout() {
        return new UserTimeOutCommand().execute();
    }

    @RequestMapping("/command/exception")
    public String commandException() {
        return new UserExceptionCommand().execute();
    }

    @RequestMapping("/command/annotation/timeout")
    public String commandAnnotationTimeout() {
        return userAnnotationCommand.timeout();
    }

    @RequestMapping("/command/annotation/exception")
    public String commandAnnotationException() {
        return userAnnotationCommand.exception();
    }

    @RequestMapping("/feign/timeout")
    public String feignTimeout() {
        return userService.timeout();
    }

    @RequestMapping("/feign/exception")
    public String feignException() {
        return userService.exception();
    }
}
