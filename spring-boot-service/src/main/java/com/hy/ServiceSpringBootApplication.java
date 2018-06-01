package com.hy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wyx
 */
@SpringBootApplication
@EnableRabbit
@MapperScan("com.hy.repository.mapper")
public class ServiceSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSpringBootApplication.class, args);
    }
}
