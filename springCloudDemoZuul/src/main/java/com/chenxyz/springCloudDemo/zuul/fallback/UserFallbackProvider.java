package com.chenxyz.springCloudDemo.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * User服务降级
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-09-26
 */
@Component
public class UserFallbackProvider implements ZuulFallbackProvider {

    /**
     * 对应的路由id，如果所有路由使用同一个fallback就返回*或者null
     * @return
     */
    @Override
    public String getRoute() {
        // return "user-service";
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        ClientHttpResponse response = new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("invoke failed, fallback...".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.TEXT_PLAIN);
                return headers;
            }
        };
        return response;
    }
}
