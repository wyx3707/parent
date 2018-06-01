package com.hy.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕捉类
 *
 * @author wyx
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ReturnVo handlerException(Exception e) {
        //类型判断
        if (e instanceof CustomException) {
            CustomException customException = (CustomException) e;
            ReturnVo returnVo = new ReturnVo(null, customException.getCode(), customException.getMsg());
            return returnVo;
        }
        return new ReturnVo(null, "500", "系统异常");
    }

}
