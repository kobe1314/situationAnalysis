package com.situation.analysis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @description: 这里我们自定义了一个AuthenticationToken----JwtToken。
 * 因为在Reaml认证方法中，我们是对 Token进行认证的。至于 UsernamePasswordToken （Shiro 中自带），
 * 我们需要 对 username 和 password 认证时就可以用它
 * @author: Kobe
 * @date: 2021/3/1 上午8:17
 * @version: v1.0
 */
@Data
@AllArgsConstructor
public class JwtToken implements AuthenticationToken {

    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
