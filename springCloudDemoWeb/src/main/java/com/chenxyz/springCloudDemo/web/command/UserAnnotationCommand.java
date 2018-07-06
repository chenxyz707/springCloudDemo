package com.chenxyz.springCloudDemo.web.command;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 使用HystrixCommand注解配置一个Hystrix
 *
 * @version 1.0
 * @date 2018-07-04
 */
@Component
public class UserAnnotationCommand {

    @Autowired
    @Qualifier("lbRestTemplate")
    RestTemplate lbRestTemplate;

    @HystrixCommand(fallbackMethod = "timeoutFallback", threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "20"),
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")
    }, commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "8000")
    })
    public String timeout() {
        return lbRestTemplate.getForObject("http://user-service/user/timeout", String.class);
    }

    public String timeoutFallback() {
        return "timeout 降级";
    }


    @HystrixCommand(fallbackMethod = "exceptionFallback", threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "20"),
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")
    }, commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String exception() {
        return lbRestTemplate.getForObject("http://user-service/user/exception", String.class);
    }

    public String exceptionFallback() {
        return "exception 降级";
    }
}
