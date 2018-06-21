package com.hy.configuration;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.hy.returnpack.ReturnVO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName FormValidationAspect
 * @Desc 做spring mvc 表单验证检查的切面
 * @Author wyx
 * @Date 2018/6/21 16:37
 * @Version 1.0
 */
@Aspect
@Component
public class FormValidationAspect {

    /**
     * 在方法的最后是BindingResult这个类的参数的
     */
    @Pointcut("execution(com.hy.returnpack.ReturnVO *..*(..,org.springframework.validation.BindingResult))")
    public void pointCut() {

    }

    /**
     * 在之前访问
     */
    @Around("pointCut()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        //当前方法名
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        //参数
        Object[] args = joinPoint.getArgs();
        if (null == args || args.length == 0) {
            return joinPoint.proceed();
        }
        //查找BindingResult类的参数
        Optional<Object> first = Arrays.stream(args).filter(a -> a instanceof BindingResult).findFirst();
        //没有BindingResult类的参数
        if (!first.isPresent()) {
            return joinPoint.proceed();
        }
        BindingResult bindingResult = (BindingResult) first.get();
        if (null == bindingResult || !bindingResult.hasFieldErrors()) {
            return joinPoint.proceed();
        }
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (CollectionUtils.isEmpty(fieldErrors)) {
            return joinPoint.proceed();
        }
        for (FieldError fieldError : fieldErrors) {
            fieldError.getField();
        }
        return ReturnVO.error("参数不正确", fieldErrors);

    }

}
