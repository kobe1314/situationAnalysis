package com.situation.analysis.service.impl;

import com.situation.analysis.entity.UserEntity;
import com.situation.analysis.mapper.primary.UserMapper;
import com.situation.analysis.service.UserService;
import com.situation.analysis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: user service implement
 * @author: Kobe
 * @date: 2021/2/28 下午3:03
 * @version: v1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    /**
     * add user
     *
     * @param user
     */
    @Override
    public void addUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanCopier copier = BeanCopier.create(user.getClass(), userEntity.getClass(), false);
        copier.copy(user, userEntity, null);
        userMapper.addUser(userEntity);
    }

    /**
     * get user information
     *
     * @param name
     * @return
     */
    @Override
    public User getUserByName(String name) {
        log.debug("getUserByName method: {}",name);
        User user = new User();
        UserEntity userEntity = userMapper.getUserByName(name);
        BeanCopier copier = BeanCopier.create(UserEntity.class, User.class, false);
        copier.copy(userEntity,user,null);
        return user;
    }
}
