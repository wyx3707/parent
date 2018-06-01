package com.hy.interceptor;

import com.hy.exception.CustomException;
import com.hy.util.AppKeyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * appKey拦截器 用于判断参数中是否传入AppKey参数名，并做校验
 *
 * @author wyx
 */
@Component
@InterceptorAnnotation(key = AppKeyInterceptor.APP_KEY)
public class AppKeyInterceptor extends HandlerInterceptorAdapter {


    private ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    public static final String APP_KEY = "appKey";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String appKey = request.getParameter(APP_KEY);
        if (StringUtils.isEmpty(appKey)) {
            throw new CustomException("210", "非法连接");
        }
        boolean verify = AppKeyUtils.verify(appKey);
        if (!verify) {
            throw new CustomException("210", "非法连接");
        }
        threadLocal.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        Long beginTime = threadLocal.get();
        System.out.println(request.getRequestURI() + "的执行时间" + (endTime - beginTime) + "毫秒");


    }
}
