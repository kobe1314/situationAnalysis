package com.situation.analysis.controller;

import com.situation.analysis.model.Result;
import com.situation.analysis.service.UserService;
import com.situation.analysis.util.JwtUtil;
import com.situation.analysis.util.Util;
import com.situation.analysis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
}
