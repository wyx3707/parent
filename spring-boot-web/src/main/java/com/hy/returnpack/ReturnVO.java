package com.hy.returnpack;

/**
 * @ClassName RuturnVO
 * @Desc 返回对象
 * @Author wyx
 * @Date 2018/6/21 17:01
 * @Version 1.0
 */
public class ReturnVO<T> implements Returnable<T> {
    private int httpCode;
    private String httpMessage;
    private T t;

    public ReturnVO(int httpCode, String httpMessage, T t) {
        this.httpCode = httpCode;
        this.httpMessage = httpMessage;
        this.t = t;
    }

    public static <T> ReturnVO<T> ok(String httpMessage) {
        return ok(httpMessage, null);
    }

    public static <T> ReturnVO<T> ok(String httpMessage, T t) {
        return new ReturnVO(HttpStatus.SUCCESS.getCode(), httpMessage, t);
    }

    public static <T> ReturnVO<T> error(String httpMessage) {
        return error(httpMessage, null);
    }

    public static <T> ReturnVO<T> error(String httpMessage, T t) {
        return new ReturnVO(HttpStatus.FAILURE.getCode(), httpMessage, t);
    }

    @Override
    public int getHttpCode() {
        return httpCode;
    }

    @Override
    public String getHttpMessage() {
        return httpMessage;
    }

    @Override
    public T getT() {
        return t;
    }
}
