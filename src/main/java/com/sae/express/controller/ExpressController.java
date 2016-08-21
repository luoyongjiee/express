package com.sae.express.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by luoqi on 2016-08-14.
 */
@Controller
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

    /**
     * 寄件页面
     * @return
     */
    @RequestMapping("toSend")
    public String toSend(){

        return "/express/send";
    }

    /**
     * 取件页面
     * @return
     */
    @RequestMapping("toPinkUp")
    public String toPinkUp(){

        return "/express/pick_up";
    }

    /**
     * 查询页面
     * @return
     */
    @RequestMapping("toQuery")
    public String toQuery(){

        return "/express/query";
    }
    /**
     * 反馈页面
     * @return
     */
    @RequestMapping("toFeedback")
    public String toFeedback(){

        return "/express/feedback";
    }
}
