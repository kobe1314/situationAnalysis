package com.situation.analysis.mapper;

import com.situation.analysis.entity.UserEntity;

/**
 * @description: user mapper
 * @author: Kobe
 * @date: 2021/2/28 下午2:55
 * @version: v1.0
 */
public interface UserMapper {
    /**
     * @param user
     */
    void addUser(UserEntity user);

    /**
     * @param name
     * @return
     */
    UserEntity getUserByName(String name);

    /**
     * @param user
     */
    void updateUser(UserEntity user);

    /**
     * @param name
     */
    void deleteUserByName(String name);
}
