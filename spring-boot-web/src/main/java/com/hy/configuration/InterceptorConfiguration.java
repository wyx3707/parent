package com.hy.configuration;

import com.hy.interceptor.InterceptorAnnotation;
import com.hy.properties.InterceptorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Map;

/**
 * 向spring容器中加入拦截器
 * 配合interceptor包下的类
 *
 * @author wyx
 */
@Configuration
@EnableConfigurationProperties({InterceptorProperties.class})
@ConditionalOnBean(HandlerInterceptor.class)
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private InterceptorProperties interceptorProperties;
    /**
     * 会将容器中全部实现HandlerInterceptor接口的bean装配到这个list中
     * 比如AppKeyInterceptor和ToKenInterceptor
     */
    @Autowired
    private List<HandlerInterceptor> handlerInterceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //获得全部的属性文件中配置的拦截路径，并使用关键字做map的key
        Map<String, InterceptorProperties.InterceptorInfo> interceptors = interceptorProperties.getKey();
        System.out.println("容器中存在{" + handlerInterceptors.size() + "}个拦截器");
        if (!CollectionUtils.isEmpty(handlerInterceptors)) {
            handlerInterceptors.parallelStream().forEach(item -> {
                //过滤参数校验的拦截器即使用InterceptorAnnotation注解的拦截器
                boolean annotationPresent = item.getClass().isAnnotationPresent(InterceptorAnnotation.class);
                if (annotationPresent) {
                    InterceptorAnnotation annotation = item.getClass().getAnnotation(InterceptorAnnotation.class);
                    String key = annotation.key();
                    //判断路径配置下是否存在注解中的关键字
                    if (interceptors.containsKey(key)) {
                        InterceptorProperties.InterceptorInfo interceptorInfo = interceptors.get(key);
                        try {
                            HandlerInterceptor handlerInterceptor = item.getClass().newInstance();
                            InterceptorRegistration interceptorRegistration = registry.addInterceptor(handlerInterceptor);
                            interceptorRegistration.addPathPatterns(interceptorInfo.getPathPatterns());
                            interceptorRegistration.excludePathPatterns(interceptorInfo.getExcludePathPatterns());
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
