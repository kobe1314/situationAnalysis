package com.situation.analysis.service;

import com.situation.analysis.util.Util;
import com.situation.analysis.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: user service test
 * @author: Kobe
 * @date: 2021/2/28 下午3:15
 * @version: v1.0
 */
@Slf4j
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        User admin = new User();
        admin.setUsername("david");
        admin.setSalt(salt);
        admin.setPassword(Util.encryptPassword("admin",salt));
        userService.addUser(admin);
        log.debug("add user finish");
    }

    @Test
    public void getUserByName() {
        User user = userService.getUserByName("kobe");
        log.debug("user name {}",user.getUsername());
    }

}
