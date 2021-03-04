package com.situation.analysis.config;

import com.situation.analysis.model.JwtToken;
import com.situation.analysis.service.UserService;
import com.situation.analysis.util.JwtUtil;
import com.situation.analysis.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @description: 获取用户信息
 * @author: Kobe
 * @date: 2021/2/28 下午2:51
 * @version: v1.0
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    UserService userService;


    /**
     *如果实现自己的token,必须要加次方法。否则会报 "does not support authentication token"
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof JwtToken;
    }

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取subject传过来的用户名
        //String username = (String) authenticationToken.getPrincipal();

        log.info("user is authenticate");
        String name= (String) authenticationToken.getPrincipal();
        String token = (String) authenticationToken.getCredentials();
        String username = JwtUtil.getUsernameFromToken(token);

        User user = userService.getUserByName(username);

        if (StringUtils.isEmpty(username) || !JwtUtil.verify(token, username)) {
            log.error("token 认证失败");
            throw new AuthenticationException("token 认证失败");
        }

        if (null == user) {
            log.error("账号或密码错误");
            throw new AuthenticationException("账号或密码错误");
        }

        //ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        //AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, this.getName());

        log.debug("用户{}认证成功", user.getUsername());
        return new SimpleAuthenticationInfo(token, token, getName());
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
