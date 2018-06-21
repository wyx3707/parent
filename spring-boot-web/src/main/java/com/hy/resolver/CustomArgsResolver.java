package com.hy.resolver;

import com.hy.vo.UserVO;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义的参数解析器
 * ps：实现HandlerMethodArgumentResolver
 *
 * @author wyx
 */
public class CustomArgsResolver implements HandlerMethodArgumentResolver {
    private final static String TOKEN = "token";
    /**
     * 用于判定是否需要处理该参数分解，返回true为需要，并会去调用下面的方法resolveArgument
     *
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //判断在参数中是否存在User类型的形参，如果有为true， 没有为false
        return methodParameter.hasParameterAnnotation(User.class);
    }
    /**
     * 从访问的参数中，做附加的操作
     *
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest httpRequest = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        String token = httpRequest.getParameter(TOKEN);
        //在这里模拟从redis中取得的用户信息
        UserVO userVO = new UserVO();
        userVO.setUserId(100);
        userVO.setUserName("wyx");
        return userVO;
    }
}
