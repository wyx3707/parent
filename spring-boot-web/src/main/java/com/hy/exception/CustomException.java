package com.hy.exception;

/**
 * 自定义的异常类
 *
 * @author wyx
 */
public class CustomException extends RuntimeException {

    private String code;
    private String msg;

    public CustomException(String code, String msg) {
        super(code);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
