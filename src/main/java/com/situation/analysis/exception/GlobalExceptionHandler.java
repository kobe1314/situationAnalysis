package com.situation.analysis.exception;

import com.situation.analysis.enums.ResultCode;
import com.situation.analysis.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * @description: Global exception handler
 * @author: Kobe
 * @date: 2021/2/17 上午11:06
 * @version: v1.0
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BizException.class)
    public Result bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return Result.error(e.getErrorCode(), e.getErrorMsg());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public Result exceptionHandler(HttpServletRequest req,  MissingServletRequestParameterException e) {
        log.error("参数验证异常！原因是:{}", e);
        return Result.error(ResultCode.BODY_NOT_MATCH);
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoSuchMethodException.class)
    public Result exceptionHandler(HttpServletRequest req, NoSuchMethodException e) {
        log.error("发生空指针异常！原因是:{}", e);
        return Result.error(ResultCode.NOT_FOUND);
    }

    

    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("未知异常！原因是:", e);
        return Result.error(ResultCode.INTERNAL_SERVER_ERROR);
    }
}
