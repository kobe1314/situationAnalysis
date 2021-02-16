package com.situation.analysis.model;

import com.situation.analysis.enums.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: result
 * @author: Kobe
 * @date: 2021/2/16 下午4:34
 * @version: v1.0
 */
@Data
@NoArgsConstructor
public class Result<T> {
    //private Integer code;
    //private String message;
    private ResultCode resultCode;
    private T data;

    public Result(ResultCode resultCode, T data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
}
