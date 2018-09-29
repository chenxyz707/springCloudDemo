package com.chenxyz.springCloudDemo.zuul.filter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * unAuthRoutes里面存储的routeId都是需要使用TokenValidateFilter过滤的
 * @see TokenValidateFilter
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-09-29
 */
@Component
@ConfigurationProperties("zuulFilter.tokenFilter")
public class TokenValidateConfiguration {

    // 在这个列表里面存储的routeId都是需要使用TokenValidateFilter过滤的
    private List<String> unAuthRoutes;

    // 给定的token
    private String staticToken;

    public List<String> getUnAuthRoutes() {
        return unAuthRoutes;
    }

    public void setUnAuthRoutes(List<String> unAuthRoutes) {
        this.unAuthRoutes = unAuthRoutes;
    }

    public String getStaticToken() {
        return staticToken;
    }

    public void setStaticToken(String staticToken) {
        this.staticToken = staticToken;
    }
}
