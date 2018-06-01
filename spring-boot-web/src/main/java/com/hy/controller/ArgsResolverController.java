package com.hy.controller;

import com.hy.resolver.User;
import com.hy.vo.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试自定义参数解析器（配合customargsresolver包下类）
 *
 * @author wyx
 */
@RestController
public class ArgsResolverController {

    @RequestMapping("/args")
    public void test(@User() UserVO userVO) {

        System.out.println(userVO.getUserName() + "-" + userVO.getUserId());
    }
}
