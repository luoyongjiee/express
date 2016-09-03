package com.sae.express.controller;

import com.sae.express.dao.model.SendInfoModel;
import com.sae.express.service.ExpressService;
import com.sae.express.util.tool.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * Created by luoqi on 2016-08-14.
 */
@Controller
public class ExpressController {

    @Autowired
    private ExpressService expressService;


    @RequestMapping("/path/{folder}/{file}")
    public String path(@PathVariable("folder") String folder,@PathVariable("file") String file  ){
        return "/"+folder+"/"+file;
    }


    @RequestMapping("addSend")
    @ResponseBody
    public String addSend(SendInfoModel sendInfo,HttpServletRequest request){
        return expressService.addSend(sendInfo).getId().toString();
    }

    @RequestMapping("addSendMsg")
    public String addSendMsg(String id,HttpServletRequest request){
        SendInfoModel sendInfo = expressService.getSendInfoModelById(id);
        request.setAttribute("sendInfo",sendInfo);
        return "/express/msg";
    }


    @RequestMapping("getSendInfoModel")
    public String getSendInfoModel(String searchInput,HttpServletRequest request){

        List<SendInfoModel> sendInfoModelList = null;
        if(StringTools.isNotBlank(searchInput)){
            sendInfoModelList =  expressService.getSendInfoModel(searchInput);
        }

        request.setAttribute("sendInfoModelList",sendInfoModelList);

        return "/express/query";
    }

    @RequestMapping("getSendDetail")
    public String getSendDetail(String id,HttpServletRequest request){
        SendInfoModel sendInfo = expressService.getSendInfoModelById(id);
        request.setAttribute("sendInfo",sendInfo);
        return "/express/sendDetail";
    }

}
