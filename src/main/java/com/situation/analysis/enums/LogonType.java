package com.situation.analysis.enums;

import lombok.Getter;

/**
 * @description: logon type
 * @author: Kobe
 * @date: 2021/10/24 下午3:52
 * @version: v1.0
 */
@Getter
public enum LogonType {
    CARD(1),
    PHONE(2),
    DINGDING(3);

    private int type;

    LogonType(int type) {
        this.type = type;
    }

    public Integer type() {
        return this.type;
    }

}
