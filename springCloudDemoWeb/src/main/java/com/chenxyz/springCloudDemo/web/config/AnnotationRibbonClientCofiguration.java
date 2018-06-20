package com.chenxyz.springCloudDemo.web.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

/**
 * 注解形式的RibbonClient配置
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-06-07
 */
public class AnnotationRibbonClientCofiguration {

    @Bean
    public ServerList<Server> ribbonServerList() {
        Server[] servers = new Server[2];
        servers[0] = new Server("127.0.0.1", 8001);
        servers[0] = new Server("127.0.0.1", 9001);
        ServerList<Server> serverList = new StaticServerList<>(servers);
        return serverList;
    }

    @Bean
    public IRule initRule() {
        return new RandomRule();
    }
}
