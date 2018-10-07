package com.chenxyz.springCloudDemo.zuul.config;

import com.chenxyz.springCloudDemo.zuul.filter.SendErrorRestFilter;
import com.chenxyz.springCloudDemo.zuul.filter.TokenValidateFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chenxyz on 2018/10/5.
 */
@Configuration
public class ZuulFilterConfig {

    @Bean
    public TokenValidateFilter tokenValidateFilter() {
        return new TokenValidateFilter();
    }

    @Bean
    public SendErrorRestFilter sendErrorRestFilter() {
        return new SendErrorRestFilter();
    }
}
