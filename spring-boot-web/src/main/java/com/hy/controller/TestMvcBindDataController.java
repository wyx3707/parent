package com.hy.controller;

import com.hy.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class TestMvcBindDataController {

    @RequestMapping("/method1")
    public void method1(@RequestParam(value = "name") String name) {
        System.out.println(name);
    }

    @RequestMapping(value = "/method2/{name}")
    public void method2(@PathVariable(value = "name") String s) {
        System.out.println(s);
    }

    @RequestMapping(value = "/method3")
    public void method3(@RequestHeader(value = "Cookie") String cookie) {
        System.out.println(cookie);
    }

    @RequestMapping(value = "/method4")
    public void method4(@RequestBody UserVO userVO) {
        System.out.println(userVO.getUserName());
    }
    @RequestMapping(value = "/method5")
    public void method5(HttpSession httpSession) {
        System.out.println(httpSession);
    }


}
