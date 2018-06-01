package com.hy.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录的用户信息实例
 *
 * @author wyx
 */
@Data
public class UserVO implements Serializable {
    private Integer userId;
    private String userName;

    public static void main(String[] args) {

    }
}
