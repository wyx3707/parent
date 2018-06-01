package com.hy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拦截器的测试的controller
 * 是依照在application.properties中配置的拦截路径做的拦截
 *
 * @author wyx
 */
@RestController
@RequestMapping("interceptor")
public class InterceptorController {

    @RequestMapping("/list")
    public String getList() {
        return "不成功";
    }

    @RequestMapping("/test")
    public String test() {
        return "成功";
    }
}
