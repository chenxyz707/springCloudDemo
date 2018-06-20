package com.chenxyz.springCloudDemo.web.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 *
 * @author chenlinchao
 * @version 1.0
 * @date 2018-06-07
 * Copyright 青海粮食云项目组
 */
@Configuration
@RibbonClient(name = "annotation-sms-service", configuration = AnnotationRibbonClientCofiguration.class)
public class AnnotationRibbonClient {
}
