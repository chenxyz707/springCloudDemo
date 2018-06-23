package com.chenxyz.springCloudDemo.web.config.ribbon;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

/**
 * 直接使用API的RibbonClient配置
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-06-07
 */
public class AnnotationRibbonClientCofiguration {

    @Bean
    public ServerList<Server> ribbonServerList() {
        Server[] servers = new Server[2];
        servers[0] = new Server("http://localhost:8001");
        servers[1] = new Server("http://localhost:9001");
        ServerList<Server> serverList = new StaticServerList<>(servers);
        return serverList;
    }

    @Bean
    public IRule initRule() {
        // 轮询
        //new RoundRobinRule();

        // 选择一个最小的并发请求的server
        //new BestAvailableRule();

        // 随机
        return new RandomRule();
    }
}
