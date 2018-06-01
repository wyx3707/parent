package com.hy.controller;

import com.hy.exception.CustomException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试统一异常处理
 *
 * @author wyx
 */
@RestController
@RequestMapping("exception")
public class ExceptionController {

    @RequestMapping("/testException")
    public void getList() {
        throw new CustomException("201", "自定义异常");
    }
}
