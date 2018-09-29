package com.chenxyz.springCloudDemo.zuul.filter;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

/**
 * zuul有个默认的SendErrorFilter，会重定向到/error
 * 如果需要启用自定义的errorFilter，需要关掉zuul的SendErrorFilter
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-09-29
 */
public class SendErrorRestFilter extends SendErrorFilter {
}
