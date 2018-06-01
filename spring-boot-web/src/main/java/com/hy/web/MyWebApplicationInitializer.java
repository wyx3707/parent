package com.hy.web;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 这个类相当于在web开发中的web.xml文件的地位
 *
 * @ClassName WebApplicationInitializer
 * @Desc TODO
 * @Author wyx
 * @Date 2018/5/4 11:27
 * @Version 1.0
 */
public class MyWebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet());
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");
    }
}
