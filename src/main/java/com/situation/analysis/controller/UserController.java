package com.situation.analysis.controller;

import com.situation.analysis.model.Result;
import com.situation.analysis.service.UserService;
import com.situation.analysis.util.JwtUtil;
import com.situation.analysis.util.Util;
import com.situation.analysis.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: User Controller
 * @author: Kobe
 * @date: 2021/2/28 下午5:37
 * @version: v1.0
 */
@Slf4j
@RestController
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/user/login")
    public Result login(String username, String password) {
        User user = userService.getUserByName(username);

        if (null != user && user.getPassword().equals(Util.encryptPassword(password,user.getSalt()))) {
        //if (null != user && user.getPassword().equals(password)) {
            Map<String, String> response = new HashMap();
            response.put("token", JwtUtil.createToken(user.getUsername()));
            return Result.success(response);
        } else {
            log.error("用户名或密码不存在");
            throw new UnauthenticatedException("用户名或密码不存在");
        }
    }

    @GetMapping("/user/hello")
    public String hello() {
        return "hello";
    }

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
