package com.situation.analysis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.situation.analysis.enums.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: result
 * @author: Kobe
 * @date: 2021/2/16 下午4:34
 * @version: v1.0
 */

@Data
@NoArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;
    @JsonIgnore
    private String message;
    private T data;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL.getCode());
        result.setMessage(ResultCode.FAIL.getMessage());
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL.getCode());
        result.setMessage(ResultCode.FAIL.getMessage());
        result.setData(data);
        return result;
    }
}
