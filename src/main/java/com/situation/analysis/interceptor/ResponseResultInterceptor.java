package com.situation.analysis.interceptor;

import com.situation.analysis.annotation.ResponseResult;
import com.situation.analysis.constants.CommonConstants;
import com.situation.analysis.entity.MonitoringLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @description: response result interceptor
 * @author: Kobe
 * @date: 2021/2/16 下午9:45
 * @version: v1.0
 */
@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            Annotation annotationOnClass = clazz.getAnnotation(ResponseResult.class);
            Annotation annotationOnMethod = method.getAnnotation(ResponseResult.class);
            if(!ObjectUtils.isEmpty(annotationOnClass) || !ObjectUtils.isEmpty(annotationOnMethod)) {
                log.debug("wrapper response");
                request.setAttribute(CommonConstants.INCLUDE_RESPONSE_RESULT,true);
            }
        }

        return true;
    }
}
