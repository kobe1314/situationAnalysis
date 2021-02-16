package com.situation.analysis.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @description: ResultCode
 * @author: Kobe
 * @date: 2021/2/16 下午4:19
 * @version: v1.0
 */
@Getter
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 失败
     */
    FAIL(400, "fail");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }


}
