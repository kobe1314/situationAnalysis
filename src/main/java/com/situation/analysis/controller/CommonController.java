package com.situation.analysis.controller;

import com.situation.analysis.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: handler common flow
 * @author: Kobe
 * @date: 2021/3/4 下午11:00
 * @version: v1.0
 */
@Slf4j
@RestController
public class CommonController {

    @GetMapping("/unauthorized/{message}")
    public Result unauthorized(@PathVariable String message) {
        return Result.error(401, message);
    }

    @GetMapping("/error")
    public Result error(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        Throwable cause = exception.getCause();
        if (cause instanceof UnsupportedTokenException) {
            throw new UnsupportedTokenException(exception.getMessage());
        } else if (cause instanceof AuthenticationException) {
            throw new AuthenticationException(exception.getMessage());
        } else {
            throw exception;
        }
    }
}
