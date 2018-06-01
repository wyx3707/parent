package com.hy.controller;

import com.hy.validate.LoginValidate;
import com.hy.vo.LoginVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //我们知道在Controller类中通过@InitBinder标记的方法只有在请求当前Controller的时候才会被执行
    //所以在这里注册校验器
    @InitBinder
    public void initBainder(DataBinder binder) {
        binder.replaceValidators(new LoginValidate());
    }

    @RequestMapping(value = "/s", method = RequestMethod.POST)
    public void login(@Validated LoginVO user) {
//        if (br.hasErrors()) {
            System.out.println("验证失败");
//        } else {
//            System.out.println("验证成功");
//        }
    }
}
