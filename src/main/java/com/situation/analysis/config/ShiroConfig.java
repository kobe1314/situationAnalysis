package com.situation.analysis.config;

import com.situation.analysis.interceptor.JwtFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: shiro启动时候的初始化工作，比如哪些是需要认证，哪些不需要认证；缓存配置设置；shiro权限数据在页面展示时整合需要的模板套件配置
 * @author: Kobe
 * @date: 2021/2/28 下午2:34
 * @version: v1.0
 */
@Profile("test")
@Configuration
public class ShiroConfig {

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        //shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }


    /**
     * securityManager 核心配置
     * 安全控制层
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());

        //关闭shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator evaluator = new DefaultSessionStorageEvaluator();
        evaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(evaluator);
        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        //设置遇到未登录、未授权等情况时候，请求这些地址，返回相应的错误
        //shiroFilter.setLoginUrl("/user/shiroError?errorId=" + Constant.NEED_LOGIN);
        //shiroFilter.setUnauthorizedUrl("/user/shiroError?errorId=" + Constant.NO_UNAUTHORIZED);

        //设置自定义的拦截器
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("jwt",new JwtFilter());
        shiroFilter.setFilters(filterMap);

        //拦截器，配置访问权限 必须是LinkedHashMap，因为它必须保证有序。滤链定义，从上向下顺序执行，一般将 /**放在最为下边
        Map<String, String> filterRuleMap = new LinkedHashMap<String, String>();

        // 配置不会被拦截的链接 顺序判断
        filterRuleMap.put("/user/login", "anon");
        filterRuleMap.put("/unauthorized/**","anon");
        filterRuleMap.put("/**","jwt");

        ////剩余的请求shiro都拦截
        //filterRuleMap.put("/**/*", "authc");

        shiroFilter.setFilterChainDefinitionMap(filterRuleMap);
        return shiroFilter;
    }
}
