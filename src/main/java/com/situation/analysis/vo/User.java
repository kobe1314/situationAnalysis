package com.situation.analysis.vo;

import lombok.Data;

/**
 * @description: user information
 * @author: Kobe
 * @date: 2021/2/28 下午3:01
 * @version: v1.0
 */
@Data
public class User {
    private String username;
    private String password;
    private String salt;
}
