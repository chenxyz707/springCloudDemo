package com.chenxyz.springCloudDemo.web.service.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户接口的FeignClient
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-07-04
 */
@FeignClient(name="user-service", fallback = UserServiceFallback.class)
public interface UserService {

    @RequestMapping(value = "/user/timeout", method = RequestMethod.GET)
    public String timeout();

    @RequestMapping(value = "/user/exception", method = RequestMethod.GET)
    public String exception();
}
