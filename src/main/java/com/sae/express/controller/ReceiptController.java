package com.sae.express.controller;

import com.sae.express.dao.model.PickUp;
import com.sae.express.dao.model.PickUpInfoModel;
import com.sae.express.dao.model.PickUpModel;
import com.sae.express.dao.model.PickUpModelExample;
import com.sae.express.service.ExpressService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    /**
     * 进入收件订单页面
     * @return
     */
    @RequestMapping("insert/pickUpOrder")
    public String insertPickUpList(){
        return "/express/pick_up_order";
    }

    /**
     * 添加收件订单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "insert/pickUpOrder" ,method = RequestMethod.POST)
    public String insertPickUpList(String pickUpModelListJson,String pickUserJson){
        JSONArray jsonArray = JSONArray.fromObject(pickUpModelListJson);
        JSONObject jsonObject = JSONObject.fromObject(pickUserJson);

        List<PickUpInfoModel>  pickUpModellist = (List<PickUpInfoModel>)JSONArray.toCollection(jsonArray, PickUpInfoModel.class);
        PickUp pickUp = (PickUp)JSONObject.toBean(jsonObject, PickUp.class);

        //录入用户信息
        PickUp pickUp2=expressService.insertPickUp(pickUp);

        PickUpInfoModel pickUpInfoModel;
        for (int i=0;i<pickUpModellist.size();i++){
            pickUpInfoModel=pickUpModellist.get(i);
            if (pickUpInfoModel!=null){
                //录入用户收件单信息
                pickUpInfoModel.setPickUpId(pickUp2.getId());
                try {
                    pickUpInfoModel.setExpressDate(new SimpleDateFormat("yyyy-MM-dd HH-mm").parse(pickUpInfoModel.getExpressDateStr()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                expressService.insertPickUpInfoModel(pickUpInfoModel);
            }
       }
        return "success";
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
