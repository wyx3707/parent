package com.hy.controller;

import com.hy.vo.ValidVO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * spring boot整合valid
 *
 * @author wyx
 */
@RestController
public class ValidController {

    /**
     * 在调用这个controller时，需要先验证ValidVO是否正确，
     * （ValidVO的规则是实体上的注解标识）
     * 如果成功则bindingResult.hasErrors()为false，否则为true
     *
     * @param validVO
     * @param bindingResult
     * @return
     */
    @RequestMapping("/valid")
    public String validator(@Valid ValidVO validVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "参数化错误";
        }
        return "ok";
    }


}
