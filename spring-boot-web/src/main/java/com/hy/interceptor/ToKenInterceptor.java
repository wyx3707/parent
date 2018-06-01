package com.hy.interceptor;

import com.hy.exception.CustomException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ToKen 拦截器，为了校验参数中是否传入ToKen
 *
 * @author wyx
 */
@Component
@InterceptorAnnotation(key = ToKenInterceptor.TO_KEN)
public class ToKenInterceptor extends HandlerInterceptorAdapter {

    public static final String TO_KEN = "toKen";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String parameter = request.getParameter(TO_KEN);
        if (StringUtils.isEmpty(parameter)) {
            throw new CustomException("210", "登录已失效");
        }
        return true;
    }
}
