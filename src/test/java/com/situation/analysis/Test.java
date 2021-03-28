package com.situation.analysis;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description: Test
 * @author: Kobe
 * @date: 2021/3/27 下午3:26
 * @version: v1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
    }
}
