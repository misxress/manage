package com.chuangxin.manage.service;

import com.chuangxin.manage.model.ExceptionBean;
import com.chuangxin.manage.model.ExceptionBeanType;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    /**
     * 登录的业务管理
     * @param username 用户名
     * @param password 密码
     * @throws ExceptionBean 抛出异常
     */
    public void login(String username, String password) throws ExceptionBean {

        throw new ExceptionBean(ExceptionBeanType.USER_INPUT_ERROR,"登陆失败");
    }
}
