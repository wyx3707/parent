package com.hy.returnpack;

/**
 * 接口返回结果状态
 * @author wyx
 */
public enum HttpStatus{

    SUCCESS(200),
    FAILURE(201);

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    HttpStatus(int code) {
        this.code = code;
    }
}
