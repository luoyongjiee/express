package com.sae.express.controller;


import com.sae.express.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by luoqi on 2016-09-27.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("login")
    @ResponseBody
    public Object addSend(String userId,String password){
        return loginService.login(userId,password);
    }
}
