package com.situation.analysis.exception;

import com.situation.analysis.enums.ResultCode;
import lombok.Data;

/**
 * @description: biz excetpion
 * @author: Kobe
 * @date: 2021/2/17 上午11:08
 * @version: v1.0
 */

@Data
public class BizException extends RuntimeException{
    private int errorCode;
    private String errorMsg;


    public BizException(ResultCode resultCode) {
        this.errorCode = resultCode.getCode();
        this.errorMsg = resultCode.getMessage();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(int errorCode, String errorMsg, Throwable cause) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
