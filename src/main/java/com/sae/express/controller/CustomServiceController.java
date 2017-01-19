package com.sae.express.controller;


import com.sae.express.dao.model.CustomMsgModel;
import com.sae.express.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by luoqi on 2016-10-24.
 */
@Controller
public class CustomServiceController {

    private static String[] questions = {"如何取件","如何寄件","我的快递什么时候派送"};

    private static String[] answers = {"请点击菜单栏中\"我要递递\"中的我要取件"};

    @Autowired
    private CustomService customService;

    @RequestMapping("/custom/msg")
    @ResponseBody
    public Object msg(String msg) {
        Map<String,Object> result = new HashMap<String, Object>();
        List<CustomMsgModel> resultList =  customService.getgetCustomMsgModel(msg);
        if(resultList == null || resultList.size() == 0){
            resultList =  customService.getgetCustomMsgModel(null);
        }

        result.put("result",resultList);
        return result;
    }

    @RequestMapping("/custom/showMsg")
    @ResponseBody
    public Object showMsg(Integer id,HttpServletRequest request){
        return customService.getCustomMsgModelById(id);
    }


}
