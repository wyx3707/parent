package com.hy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试redis 的controller
 *
 * @author wyx
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("addCache")
    public void getList() {
        ValueOperations<String, Object> objectObjectValueOperations = redisTemplate.opsForValue();
        objectObjectValueOperations.set("name", "wyx");
        Object name = objectObjectValueOperations.get("name");
        System.out.println(name);
    }
}
