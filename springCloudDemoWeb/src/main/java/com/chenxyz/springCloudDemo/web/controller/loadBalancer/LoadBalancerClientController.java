package com.chenxyz.springCloudDemo.web.controller.loadBalancer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by chenxyz on 2018/6/10.
 */
@RestController
@RequestMapping("/loadBalancer/lbClient")
public class LoadBalancerClientController {

    @Autowired
    LoadBalancerClient client;

    @Autowired
    RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadBalancerClientController.class);

    @RequestMapping("/eureka/querySMS")
    public String eurekas() {
        ServiceInstance serviceInstance = client.choose("sms-service");
        URI uri = serviceInstance.getUri();
        LOGGER.info("load balancer with eureka choose uri : {}", uri);
        final URI resolve = uri.resolve("/sms");
        return restTemplate.getForObject(resolve, String.class);
    }

    /*Error creating bean with name 'retryableRibbonLoadBalancingHttpClient' defined in org.springframework.cloud.netflix.ribbon.apache.HttpClientRibbonConfiguration: Unsatisfied dependency expressed through method 'retryableRibbonLoadBalancingHttpClient' parameter 2; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'ribbonLoadBalancer' defined in org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.netflix.loadbalancer.ILoadBalancer]: Factory method 'ribbonLoadBalancer' threw exception; nested exception is java.lang.NullPointerException*/
    @RequestMapping("/annotation/querySMS")
    public String annotation() {
        ServiceInstance serviceInstance = client.choose("annotation-sms-service");
        URI uri = serviceInstance.getUri();
        LOGGER.info("load balancer with annotation choose uri : {}", uri);
        final URI resolve = uri.resolve("/sms");
        return restTemplate.getForObject(resolve, String.class);
    }

    @RequestMapping("/properties/querySMS")
    public String properties() {
        ServiceInstance serviceInstance = client.choose("properties-sms-service");
        URI uri = serviceInstance.getUri();
        LOGGER.info("load balancer with properties choose uri : {}", uri);
        final URI resolve = uri.resolve("/sms");
        return restTemplate.getForObject(resolve, String.class);
    }

}