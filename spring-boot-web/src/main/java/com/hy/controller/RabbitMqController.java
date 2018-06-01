package com.hy.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试rabbit mq
 *
 * @author wyx
 */
@RestController
@RequestMapping("rabbit")
public class RabbitMqController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public void getList() {
        System.out.println("开始发送");
        rabbitTemplate.convertAndSend("queue_user_login", "", "");
        System.out.println("发送了");
    }
}
