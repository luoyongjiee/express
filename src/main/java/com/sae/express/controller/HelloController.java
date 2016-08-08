package com.sae.express.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by luoqi on 2016-08-06.
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public Object hello(){
        return "kkk";
    }

    @RequestMapping("login")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("home")
    public String index(){
        return "index";
    }
}
