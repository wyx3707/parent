package com.hy.configuration;

import com.hy.resolver.CustomArgsResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 注册自定义的参数解析器
 * 配合resolver包下的类
 *
 * @author wyx
 */
@Configuration
public class ResolverConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CustomArgsResolver());
    }
}
