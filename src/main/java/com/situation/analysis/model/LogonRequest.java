package com.situation.analysis.model;

import lombok.Data;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/10/24 下午3:48
 * @version: v1.0
 */
@Data
public class LogonRequest {
    private String cardId;
    private String name;
    private String code;
    private Integer type;
    private String phoneNumber;
}
