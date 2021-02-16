package com.situation.analysis.handler;

import com.situation.analysis.constants.CommonConstants;
import com.situation.analysis.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: response result handler
 * @author: Kobe
 * @date: 2021/2/16 下午10:16
 * @version: v1.0
 */
@Slf4j
@ControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice {

    /**
     *
     * 先判断request里面是否包含INCLUDE_RESPONSE_RESULT，如果没有包含则直接返回
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        Object included =  request.getAttribute(CommonConstants.INCLUDE_RESPONSE_RESULT);
        if (ObjectUtils.isEmpty(included)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.debug("Wrapper response body");
        return Result.success(o);
    }
}
