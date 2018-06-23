package com.chenxyz.springCloudDemo.web.config.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 声明一个客户端
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-06-07
 */
@Configuration
@RibbonClient(name = "annotation-sms-service", configuration = AnnotationRibbonClientCofiguration.class)
public class AnnotationRibbonClient {
}
