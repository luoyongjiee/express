package com.sae.express.controller;

import com.google.gson.reflect.TypeToken;

import com.sae.express.dao.model.PickUpInfoModel;
import com.sae.express.dao.model.PickUpModel;
import com.sae.express.dao.model.PickUpModelExample;
import com.sae.express.repository.DateRepository;
import com.sae.express.service.PickUpService;
import com.sae.express.util.tool.DateTool;
import com.sae.express.util.tool.StringTools;
import com.sae.express.util.wechat.GsonUtil;
import com.sae.express.vo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author： Administrator
 * @Date ： 2016/9/3. 21:59
 * <p/>
 * 收件
 */
@Controller
public class PickUpController {

    private static Map<String, String> expressMap = new HashMap<String, String>();

    @Autowired
    private PickUpService pickUpService;

    @Autowired
    private DateRepository dateRepository;

    static {
        List<String> expressList = Arrays.asList("中通快递", "圆通快递", "申通快递", "韵达快递", "顺丰快递", "邮政快递", "优速快递", "天猫", "京东", "百世汇通", "国通快递","其他");
        for (int i = 0; i < expressList.size(); i++) {
            expressMap.put(String.valueOf(i+1), expressList.get(i));
        }
    }

    //添加收件请求单
    @RequestMapping(value = "insert/pickUpOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object insertPickUpList(String pickUpModelListJson, String pickUserJson,HttpSession session) {

        List<PickUpInfoModel> pickUpModellist = GsonUtil.fromJson(pickUpModelListJson, new TypeToken<List<PickUpInfoModel>>() {
        }.getType());
        PickUpModel pickUp = GsonUtil.fromJson(pickUserJson, PickUpModel.class);
        pickUp.setUserId((String) session.getAttribute("openId"));

        int sum = 0;
        for (PickUpInfoModel pickUpInfoModel : pickUpModellist) {
            sum = sum + pickUpInfoModel.getCount()*2;
        }
        pickUp.setMoney(sum);

        pickUp.setOrderStatus("0");
        pickUp.setPayStatus("0");

        pickUp = pickUpService.insertPickUpModel(pickUp);


        for (PickUpInfoModel pickUpInfoModel : pickUpModellist) {
            //录入用户收件单信息
            pickUpInfoModel.setPickUpId(pickUp.getId());
            pickUpInfoModel.setExpressDate(DateTool.parse(pickUpInfoModel.getExpressDateStr(), DateTool.YYYY_MM_DD_HH_MM));
            pickUpService.insertPickUpInfoModel(pickUpInfoModel);
        }


        return pickUp.getId();
    }

    //收件信息详情
    @RequestMapping(value = "pickUp/Detail")
    public String showPickUpDetail(Integer id, Model model, Boolean showMsg) {
        List<PickUpInfoModel> pickUpInfoModelList = pickUpService.getPickUpInfoModelList(id);
        model.addAttribute("pickUpInfoList", pickUpInfoModelList);
        model.addAttribute("pickUp", pickUpService.getPickUpModelById(id));

        if (pickUpInfoModelList != null) {
            for (PickUpInfoModel pickUpInfoModel : pickUpInfoModelList) {
                pickUpInfoModel.setExpress(expressMap.get(pickUpInfoModel.getExpress()));
            }
        }
        if (showMsg != null) {
            model.addAttribute("showMsg", false);
        } else {
            model.addAttribute("showMsg", true);
        }

        return "/express/pick_up_detail";
    }



    @RequestMapping("pickUp/getPickUpModel")
    public Object getPickUpModel(String searchInput, HttpServletRequest request) {
        List<PickUpModel> pickUpModelList = pickUpService.getPickUpModel(searchInput);

        if (StringTools.isNotBlank(searchInput)) {
            pickUpModelList = pickUpService.getPickUpModel(searchInput);
        }
        request.setAttribute("pickUpList", pickUpModelList);
        return "/express/query_pick_up";

    }


    //查询收件列表
    @RequestMapping("pickUp/pick_up_list")
    public String queryPickUpList(Model model) {
        model.addAttribute("pickUpList", pickUpService.getPickUpModelPage(0, 10));
        return "/express/pick_up_list";

    }

    //异步分页请求收件列表
    @ResponseBody
    @RequestMapping(value = "pickUp/page", method = RequestMethod.POST)
    public Object queryPickUpListPage(Integer offset, Integer limit) {
        return pickUpService.getPickUpModelPage(offset, limit);
    }

    //查询收件列表
    @RequestMapping("pickUp/showPickUpList")
    public String showPickUpList(Model model,String date,String express) {
        if(StringTools.isBlank(date)){
            date = dateRepository.currentDate() ;
        }
        List<PickUpInfoModel> pickUpInfoModelList = pickUpService.getPickUpInfoModelList(date,express);
        model.addAttribute("pickUpInfoList",pickUpInfoModelList);
        model.addAttribute("pickUpList", pickUpService.showPickUpModel(pickUpInfoModelList));
        model.addAttribute("expressList",expressMap);
        model.addAttribute("express",express);



        model.addAttribute("date",date);
        return "/express/pick_up_list_new";
    }

    //收件信息详情
    @RequestMapping(value = "pickUp/showPickUpInfo")
    public String showPickUpInfo(Integer id, Model model, Boolean showMsg) {
        List<PickUpInfoModel> pickUpInfoModelList = pickUpService.getPickUpInfoModelList(id);
        model.addAttribute("pickUpInfoList", pickUpInfoModelList);
        model.addAttribute("pickUp", pickUpService.getPickUpModelById(id));

        if (pickUpInfoModelList != null) {
            for (PickUpInfoModel pickUpInfoModel : pickUpInfoModelList) {
                pickUpInfoModel.setExpress(expressMap.get(pickUpInfoModel.getExpress()));
            }
        }
        if (showMsg != null) {
            model.addAttribute("showMsg", false);
        } else {
            model.addAttribute("showMsg", true);
        }

        return "/express/pick_up_detail_new";
    }

    @ResponseBody
    @RequestMapping("pickUp/status")
    public Object updatePickUpStatus(Integer pickUpId,String status){
        return pickUpService.updatePickUpStatus(pickUpId,status);
    }

    @ResponseBody
    @RequestMapping("pickUp/updatePickUpOrderStatus")
    public Object updatePickUpOrderStatus(Integer pickUpId,String status){
        return pickUpService.updatePickUpOrderStatus(pickUpId,status);
    }

    @ResponseBody
    @RequestMapping("pickUp/userInfo")
    public Object userInfo(HttpSession session){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        String userId = (String) session.getAttribute("openId");
        resultMap.put("data", null);
        if(StringTools.isBlank(userId)){
            return resultMap;
        }

        List<PickUpModel> pickUpModelList = pickUpService.getPickUpModelByUserId(userId);
        resultMap.put("data", null);
        if(pickUpModelList != null && pickUpModelList.size()>0){
            resultMap.put("data", pickUpModelList.get(pickUpModelList.size() - 1));
        }
        return  resultMap;
    }

    @ResponseBody
    @RequestMapping("pickUp/updateOrderStatus")
    public Object updateOrderStatus(@RequestBody List<OrderInfo> orderInfoList){
        Map<String,Object> resultMap = new HashMap<String, Object>();

        for(OrderInfo orderInfo:orderInfoList){
            pickUpService.updatePickUpOrderStatus(orderInfo.getId(),orderInfo.getStatus());
        }

        return resultMap;
    }

}
