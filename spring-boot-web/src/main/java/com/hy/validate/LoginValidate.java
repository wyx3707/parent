package com.hy.validate;


import com.alibaba.dubbo.common.utils.StringUtils;
import com.hy.vo.LoginVO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 这个是验证登录时密码是否存在的spring mvc 验证
 *
 * @author wyx
 */
public class LoginValidate implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return LoginVO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LoginVO loginVO = (LoginVO) o;
        if (StringUtils.isEmpty(loginVO.getPass())) {
            errors.rejectValue("password", null, null, "password is null");
        }
    }
}
