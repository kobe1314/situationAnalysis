package com.situation.analysis.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @description: utils
 * @author: Kobe
 * @date: 2021/2/28 下午4:12
 * @version: v1.0
 */
public class Util {

    public static String encryptPassword(String password,String salt) {
        int times = 2;
        String algorithmName = "md5";
        String encodePassword = new SimpleHash(algorithmName, password, salt, times).toString();
        return encodePassword;

    }
}
