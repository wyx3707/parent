package com.hy.controller;

import com.hy.resolver.User;
import com.hy.returnpack.ReturnVO;
import com.hy.vo.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试自定义参数解析器（配合resolver包下类）
 * ps：在参数中使用@User注解
 * 就可以直接使用该对象中的属性，功能实现在resolver下
 * <p>
 * 步骤
 * 1)生成自定义的注解类,如 User
 * 2）实现一个HandlerMethodArgumentResolver接口的类 如:CustomArgsResolver，在其中做代码处理
 * 3）将步骤二中的类加入在spring 容器中  如：ResolverConfiguration
 *
 * @author wyx
 */
@RestController
public class ArgsResolverController {

    @RequestMapping("/args")
    public ReturnVO test(@User UserVO userVO) {
        System.out.println(userVO.getUserName() + "-" + userVO.getUserId());
        return ReturnVO.ok("已获取到参数信息" + userVO.getUserName() + "-" + userVO.getUserId());
    }
}
