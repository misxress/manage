package com.chuangxin.manage.controller;


import com.chuangxin.manage.model.ExceptionBean;
import com.chuangxin.manage.model.ResponseBean;
import com.chuangxin.manage.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping("/auth/login")
    public ResponseBean login(String username, String password) {

        try {
            authService.login(username, password);
        }catch (ExceptionBean e) {
            return ResponseBean.error(e);
        }

        return ResponseBean.ok("登陆成功");
    }


    @RequestMapping("/auth/refresh")
    public ResponseBean refresh(HttpServletRequest request) {
        request.getHeader("jwt");
        return ResponseBean.ok("aa", request.getHeader("jwt"));
    }
}
