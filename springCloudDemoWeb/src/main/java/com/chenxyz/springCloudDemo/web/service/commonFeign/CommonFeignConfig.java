package com.chenxyz.springCloudDemo.web.service.commonFeign;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

/**
 * Created by chenxyz on 2018/5/27.
 */
public class CommonFeignConfig {

    @Bean
    public Contract feignContract(ConversionService feignConversionService) {
        return new feign.Contract.Default();
    }
}
