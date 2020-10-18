package com.hellojqk.jsbdemo.middleware.interceptor;

import com.google.common.base.Strings;
import com.hellojqk.jsbdemo.constant.LoggerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author wangyang
 * @date 2020/10/16 10:29 上午
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) {
        MDC.put(LoggerConstants.X_REQUEST_ID, request.getHeader("X-Request-Id"));
        MDC.put(LoggerConstants.TRACE_ID, request.getHeader("X-B3-Traceid"));
        final String uid = UUID.randomUUID().toString();
        MDC.put(LoggerConstants.REQUEST_ID, uid);
        String clientIp = request.getRemoteAddr();
        MDC.put(LoggerConstants.CLIENT_IP, clientIp);
        MDC.put(LoggerConstants.TITLE, request.getRequestURI());

        String xColipuRequestId = request.getHeader("x-request-id");
        if (Strings.isNullOrEmpty(xColipuRequestId)) {
            xColipuRequestId = UUID.randomUUID().toString();
        }
        response.setHeader("x-request-id", xColipuRequestId);
        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
                           @Nullable final ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
                                @Nullable final Exception ex) throws Exception {
    }
}