package com.chenxyz.springCloudDemo.user.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * 文件上传配置
 * 已经在application.yaml文件中进行了设置
 * 此处不需要再启用配置
 * @author chenxyz
 * @version 1.0
 * @date 2018-10-09
 */
//@Configuration
public class UploadConfig {

    public static final String maxFileSize = "1024MB";

    public static final String maxRequestSize = "2048MB";

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大 对应配置项spring.http.multipart.maxFileSize
        factory.setMaxFileSize(maxFileSize);
        // 设置总上传数据总大小 对应配置项spring.http.multipart.maxRequestSize
        factory.setMaxRequestSize(maxRequestSize);
        return factory.createMultipartConfig();
    }
}
