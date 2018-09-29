package com.chenxyz.springCloudDemo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * 一个pre ZuulFilter
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-09-29
 */
@Component
public class TokenValidateFilter extends ZuulFilter {

    protected static final Logger logger = LoggerFactory.getLogger(TokenValidateFilter.class);

    @Autowired
    private TokenValidateConfiguration tvConfig;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return tvConfig.getUnAuthRoutes().contains(ctx.get(FilterConstants.PROXY_KEY));
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String token = request.getHeader("Authorization");
        if (token == null) {
            forbidden();
            return null;
        }

        String staticToken = tvConfig.getStaticToken();
        if (StringUtils.isBlank(staticToken)) {
            logger.error("zuulFilter.tokenFilter.staticToken was not set");
            forbidden();
        } else if (!staticToken.equals(token)) {
            forbidden();
        }
        return null;
    }

    /**
     * 设置response的状态码为403
     */
    private void forbidden() {
        // zuul中，将请求附带的信息存在线程变量中。
        RequestContext.getCurrentContext().setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        ReflectionUtils.rethrowRuntimeException(new ZuulException("token is not valid", HttpStatus.FORBIDDEN.value(),
                "token校验不通过"));
    }
}
