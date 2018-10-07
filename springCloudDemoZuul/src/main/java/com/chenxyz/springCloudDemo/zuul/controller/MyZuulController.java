package com.chenxyz.springCloudDemo.zuul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * zuul Controller
 * 一个测试接口用于测试Zuul的forward功能：跳转到一个本地路径
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-09-26
 */
@RestController
@RequestMapping("/myZuul")
public class MyZuulController {

    @RequestMapping("/test")
    public String test() {
        return "Hello, you are visiting a local endpoint!";
    }
}
