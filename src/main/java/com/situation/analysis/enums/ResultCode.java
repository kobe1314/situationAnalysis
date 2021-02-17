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
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!"),
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
