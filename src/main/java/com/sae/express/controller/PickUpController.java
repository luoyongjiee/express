package com.sae.express.controller;

import com.google.gson.reflect.TypeToken;
import com.sae.express.dao.model.PickUp;
import com.sae.express.dao.model.PickUpInfoModel;
import com.sae.express.dao.model.PickUpModel;
import com.sae.express.dao.model.PickUpModelExample;
import com.sae.express.service.ExpressService;
import com.sae.express.util.tool.DateTool;
import com.sae.express.util.wechat.GsonUtil;
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
 * <p/>
 * 收件
 */
@Controller
public class PickUpController {

    @Autowired
    private ExpressService expressService;


    /**
     * 进入收件订单页面
     *
     * @return
     */
    @RequestMapping("insert/pickUpOrder")
    public String insertPickUpList() {
        return "/express/pick_up_order";
    }

    /**
     * 添加收件订单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "insert/pickUpOrder", method = RequestMethod.POST)
    public String insertPickUpList(String pickUpModelListJson, String pickUserJson,Model model) {

        List<PickUpInfoModel> pickUpModellist = GsonUtil.fromJson(pickUpModelListJson, new TypeToken<List<PickUpInfoModel>>(){}.getType());
        PickUp pickUp = GsonUtil.fromJson(pickUserJson, PickUp.class);
        //录入用户信息
        pickUp = expressService.insertPickUp(pickUp);
        for (PickUpInfoModel pickUpInfoModel : pickUpModellist) {
            //录入用户收件单信息
            pickUpInfoModel.setPickUpId(pickUp.getId());
            pickUpInfoModel.setExpressDate(DateTool.parse(pickUpInfoModel.getExpressDateStr(), DateTool.YYYY_MM_DD_HH_MM));
            expressService.insertPickUpInfoModel(pickUpInfoModel);
        }

        model.addAttribute("pickUpInfoList",pickUpModellist);
        model.addAttribute("pickUp",pickUp);

        return "pick_up_success";
    }

    /**
     * 初始化收件列表
     *
     * @param searchInput
     * @param model
     * @return
     */
    @RequestMapping("query/receiptList")
    public String querySendList(String searchInput, Model model) {
      /*  PickUpModelExample examplenew PickUpModelExample();
        model.addAttribute("receiptList", expressService.getPickUpModelPage());
        return "/express/receipt_list";*/
        return null;
    }

    /**
     * 异步获取收件列表
     *
     * @param example
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "query/receiptList", method = RequestMethod.POST)
    public List<PickUpModel> querySendListPage(PickUpModelExample example) {
        return expressService.getPickUpModelPage(example);
    }
}
