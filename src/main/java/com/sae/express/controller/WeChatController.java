package com.sae.express.controller;

import com.sae.express.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by luoqi on 2016-08-09.
 */
@Controller
public class WeChatController {

    private final static String TOKEN = "wechat";

    @Autowired
    private CommonService commonService;

    @RequestMapping(value="wechat")
    @ResponseBody
    public Object wechat(String signature,String timestamp,String nonce,String echostr){

        if(commonService.checkSignature(TOKEN, timestamp,  nonce,  signature)){
            return  echostr;
        }

        return "wechat";
    }

}
