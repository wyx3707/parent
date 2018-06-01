package com.hy.controller;

import com.hy.service.api.ServiceItemService;
import com.hy.service.dto.SvcServiceItemDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @ClassName DispatcherServletController
 * @Desc TODO
 * @Author wyx
 * @Date 2018/5/4 14:13
 * @Version 1.0
 */
@RestController
@RequestMapping("dispatcher")
public class DispatcherServletController {

    /**
     * DispatcherServlet会依照以下的次序请求进行处理：
     *
     * @param request
     */
    @RequestMapping("/webApplicationContextAttribute")
    public void webApplicationContext(HttpServletRequest request) {
        //第一步
        //首先，搜索应用的上下文对象 WebApplicationContext 并把它作为一个属性（attribute）
        //绑定到该请求上，以便控制器和其他组件能够使用它。属性的键名默认为 DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE
        WebApplicationContext webApplicationContext = (WebApplicationContext) request.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        //这里是从这个上下文中获取一个bean
        ServiceItemService serviceItemService = webApplicationContext.getBean(ServiceItemService.class);
        SvcServiceItemDTO svcServiceItemPO = serviceItemService.getSvcServiceItemPO(1);

        //第二步
        //将地区（locale）解析器绑定到请求上，以便其他组件在处理请求（渲染视图、准备数据
        //等）时可以获取区域相关的信息。如果你的应用不需要解析区域相关的信息，忽略它即可
        Locale locale = request.getLocale();
        String country = locale.getCountry();
        System.out.println(country);

        //第三步
        //将主题（theme）解析器绑定到请求上，以便其他组件（比如视图等）能够了解要渲染哪
        //个主题文件。同样，如果你不需要使用主题相关的特性，忽略它即可

    }
}
