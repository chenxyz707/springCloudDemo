package com.chenxyz.springCloudDemo.web.service.user;

import org.springframework.stereotype.Component;

/**
 * 降级
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-07-04
 */
@Component
public class UserServiceFallback implements UserService {

    @Override
    public String timeout() {
        return "timeout 降级";
    }

    @Override
    public String exception() {
        return "exception 降级";
    }

    @Override
    public String register() {
        return "用户注册失败";
    }
}
