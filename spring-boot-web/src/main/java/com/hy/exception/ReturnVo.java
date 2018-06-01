package com.hy.exception;

/**
 * 返回类
 *
 * @param <T>
 * @author wyx
 */
public class ReturnVo<T> {
    /**
     * 返回的对象
     */
    private T t;
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回的提示语
     */
    private String msg;

    public ReturnVo(T t, String code, String msg) {
        this.t = t;
        this.code = code;
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
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
