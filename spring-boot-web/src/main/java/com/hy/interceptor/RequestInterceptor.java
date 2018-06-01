package com.hy.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 在Console中显示访问的Controller的全限名
 *
 * @author wyx
 */
@Component
@Aspect
public class RequestInterceptor {

    /**
     * 定义切面
     * ps：拦截使用了RequestMapping注解的Controller中的方法
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointcut() {

    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) throws ClassNotFoundException {
        //访问路径
        String requestPath = joinPoint.getTarget().getClass().getName();
        Class<?> aClass = Class.forName(requestPath);
        //全限定类名
        String name = aClass.getName();
        //访问方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Request Url=" + name.concat(".").concat(methodName).concat("()"));
    }

}
