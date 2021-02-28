package com.situation.analysis.service;

import com.situation.analysis.vo.User;

/**
 * @description: user service
 * @author: Kobe
 * @date: 2021/2/28 下午2:53
 * @version: v1.0
 */
public interface UserService {
    /**
     * add user
     * @param user
     */
    void addUser(User user);

    /**
     * get user information
     * @param name
     * @return
     */
    User getUserByName(String name);

}
