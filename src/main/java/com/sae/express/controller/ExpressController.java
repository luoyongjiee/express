package com.sae.express.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by luoqi on 2016-08-14.
 */
@Controller
@RequestMapping("express")
public class ExpressController {

    @RequestMapping("main")
    public Object index(){
        return new ModelAndView("/express/index");
    }

    @RequestMapping("info")
    @ResponseBody
    public Object info(String test){
        return "中华"+test;
    }
}
