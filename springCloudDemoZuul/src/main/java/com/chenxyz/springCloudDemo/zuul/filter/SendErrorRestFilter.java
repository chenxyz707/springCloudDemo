package com.chenxyz.springCloudDemo.zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * zuul有个默认的SendErrorFilter，会重定向到/error
 * 如果需要启用自定义的errorFilter，需要关掉zuul的SendErrorFilter
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-09-29
 */
@Component
public class SendErrorRestFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(SendErrorRestFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_ERROR_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        Throwable throwable = getCause(context.getThrowable());
        // 获取response状态码
        int status = context.getResponseStatusCode();
        JSONObject info = new JSONObject();
        info.put("code", "异常码" + status);
        info.put("message", throwable.getMessage());
        // 记录日志
        logger.warn("请求异常，被error filter拦截", context.getClass());

        // 设置response
        context.setResponseBody(info.toJSONString());
        context.getResponse().setContentType("application/json;charset=UTF-8");
        context.getResponse().setStatus(HttpStatus.OK.value());
        // 处理了异常之后清空异常
        context.remove("throwable");
        return null;
    }

    private Throwable getCause(Throwable throwable) {
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        return throwable;
    }
}
