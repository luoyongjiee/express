package com.sae.express.controller;

import com.sae.express.dao.model.SendInfoModel;
import com.sae.express.dao.model.SendInfoModelExample;
import com.sae.express.service.ExpressService;
import com.sae.express.util.tool.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author： Administrator
 * @Date ： 2016/9/3. 21:59
 *
 * 寄件
 */
@Controller
public class SendController {

    @Autowired
    private ExpressService expressService;

    @RequestMapping("query/sendList")
    public String querySendList(String searchInput, Model model){
        model.addAttribute("sendList",expressService.getSendInfoModelPage(new SendInfoModelExample(searchInput,10,0)));
        return "/express/send_list";
    }

    @ResponseBody
    @RequestMapping(value = "query/sendList",method = RequestMethod.POST)
    public List<SendInfoModel> querySendListPage(SendInfoModelExample example){
        return expressService.getSendInfoModelPage(example);
    }
}
