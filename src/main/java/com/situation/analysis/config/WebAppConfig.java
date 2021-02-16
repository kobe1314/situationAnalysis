package com.situation.analysis.config;

import com.situation.analysis.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: configuration
 * @author: Kobe
 * @date: 2021/2/16 下午11:07
 * @version: v1.0
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/**");
    }
}
