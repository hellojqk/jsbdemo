package com.hellojqk.jsbdemo.config;

import com.hellojqk.jsbdemo.middleware.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

/**
 * @author wangyang
 * @date 2020/10/16 10:33 上午
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private LogInterceptor logInterceptor;


    /**
     * 配置使用启用默认的servlet配置
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //如果启用了会导致404这样的错误捕获不到
//        configurer.enable();
    }

    /**
     * 请求url不区分大小写
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 日志拦截器
        InterceptorRegistration logIR = registry.addInterceptor(logInterceptor);
        logIR.addPathPatterns("/**");
    }


}
