package com.situation.analysis.entity;

import lombok.Data;

/**
 * @description: user Entity
 * @author: Kobe
 * @date: 2021/2/28 下午2:54
 * @version: v1.0
 */
@Data
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private String salt;
}
