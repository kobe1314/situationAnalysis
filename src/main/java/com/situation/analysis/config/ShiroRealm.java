package com.situation.analysis.config;

import com.situation.analysis.service.UserService;
import com.situation.analysis.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;

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
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取subject传过来的用户名
        String username = (String) authenticationToken.getPrincipal();

        User user = userService.getUserByName(username);

        if (ObjectUtils.isEmpty(user)) {
            log.debug("authenticationInfo fail");
            return null;
        }

        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, this.getName());

        log.debug("authenticationInfo successfully");
        return authenticationInfo;
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }
}
