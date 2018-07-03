package com.chenxyz.springCloudDemo.web.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URL;


/**
 * Created by chenxyz on 2018/7/3.
 */
public class UserCommand extends HystrixCommand<String> {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserCommand.class);

    public UserCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("smsGroup"));
    }

    @Override
    protected String run() throws Exception {
        LOGGER.info("start query timeout endpoint");
        URL url = new URL("http://localhost:8002/user/timeout");
        byte[] result = new byte[1024];
        url.openStream().read(result);
        return new String(result);
    }

    @Override
    protected String getFallback() {
        // 执行出错或者开启熔断之后，使用这个方法返回
        //
        // 这种策略称为服务降级
        return "服务降级，暂时不可用";
    }
}
