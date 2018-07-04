package com.chenxyz.springCloudDemo.web.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * 异常
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-07-04
 * Copyright 青海粮食云项目组
 */
public class UserExceptionCommand extends HystrixCommand<String> {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserTimeOutCommand.class);

    public UserExceptionCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("userGroup"));
    }

    @Override
    protected String run() throws Exception {
        LOGGER.info("start query exception endpoint");
        URL url = new URL("http://localhost:8002/user/exception");
        byte[] result = new byte[1024];
        url.openStream().read(result);
        return new String(result);
    }

    @Override
    protected String getFallback() {
        // 执行出错或者开启熔断之后，使用这个方法返回
        // 这种策略称为服务降级
        return "服务降级，暂时不可用";
    }
}
