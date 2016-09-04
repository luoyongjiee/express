package com.sae.express.controller;

import com.sae.express.dao.model.PickUpModel;
import com.sae.express.dao.model.PickUpModelExample;
import com.sae.express.dao.model.SendInfoModel;
import com.sae.express.dao.model.SendInfoModelExample;
import com.sae.express.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author： Administrator
 * @Date ： 2016/9/3. 21:59
 *
 * 收件
 */
@Controller
public class ReceiptController {

    @Autowired
    private ExpressService expressService;


    @RequestMapping("query/pickup")
    public String queryPickUpList(String searchInput, Model model){
        //model.addAttribute("receipt",expressService.getSendInfoModelPage(new SendInfoModelExample(searchInput,10,0)));
        return "/express/pickUp";
    }



    /**
     * 初始化收件列表
     * @param searchInput
     * @param model
     * @return
     */
    @RequestMapping("query/receiptList")
    public String querySendList(String searchInput, Model model){
        model.addAttribute("receiptList",expressService.getPickUpModelPage(new PickUpModelExample(10,0)));
        return "/express/receipt_list";
    }

    /**
     * 异步获取收件列表
     * @param example
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "query/receiptList",method = RequestMethod.POST)
    public List<PickUpModel> querySendListPage(PickUpModelExample example){
        return expressService.getPickUpModelPage(example);
    }
}
