package com.hellojqk.jsbdemo.middleware.filter;

import com.google.common.base.Strings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangyang
 * @date 2020/10/16 10:42 上午
 */
@Order(1)
@WebFilter
@ConfigurationProperties(prefix = "cors")
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    static String options = "OPTIONS";

    public void setAllowOrigins(String[] allowOrigins) {
        this.allowOrigins = allowOrigins;
    }

    public void setAllowHeaders(String allowHeaders) {
        this.allowHeaders = allowHeaders;
    }

    public void setAllowMethods(String allowMethods) {
        this.allowMethods = allowMethods;
    }

    private String[] allowOrigins;

    private String allowHeaders;

    private String allowMethods;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取来源
        String origin = httpServletRequest.getHeader("Origin");
        //没有来源的不需要配置跨域
        if (Strings.isNullOrEmpty(origin)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        boolean canCors = false;
        for (String allowOrigin : allowOrigins) {
            if (canCors) {
                break;
            }
            //如果是配置允许的域名结尾或者是允许的域名带上:符号则允许跨域
            canCors = origin.endsWith(allowOrigin) || origin.contains(allowOrigin + ":");
        }
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if (canCors) {
            httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", allowHeaders);
            httpServletResponse.setHeader("Access-Control-Allow-Methods", allowMethods);
        }
        filterChain.doFilter(servletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
