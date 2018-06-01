package com.hy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试swagger
 *
 * @ClassName SwaggerContoller
 * @Desc TODO
 * @Author wyx
 * @Date 2018/5/30 13:32
 * @Version 1.0
 */
@Api(tags = "测试swaggercontoller")
@RestController
public class SwaggerContoller {

    @ApiOperation(value = "method方法")
    public void testSwagger() {

    }

}
