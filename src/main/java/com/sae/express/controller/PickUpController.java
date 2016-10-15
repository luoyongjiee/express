package com.sae.express.controller;

import com.google.gson.reflect.TypeToken;

import com.sae.express.dao.model.PickUpInfoModel;
import com.sae.express.dao.model.PickUpModel;
import com.sae.express.dao.model.PickUpModelExample;
import com.sae.express.service.PickUpService;
import com.sae.express.util.tool.DateTool;
import com.sae.express.util.tool.StringTools;
import com.sae.express.util.wechat.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    static {
        List<String> expressList = Arrays.asList("中通快递", "圆通快递", "申通快递", "韵达快递", "顺丰快递", "邮政快递", "优速快递", "天猫", "京东", "百世汇通", "国通快递");
        for (int i = 0; i < expressList.size(); i++) {
            expressMap.put(String.valueOf(i), expressList.get(i));
        }
    }

    /**
     * 添加收件请求单
     *
     * @param pickUpModelListJson
     * @param pickUserJson
     * @return
     */
    @RequestMapping(value = "insert/pickUpOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object insertPickUpList(String pickUpModelListJson, String pickUserJson,HttpSession session) {

        List<PickUpInfoModel> pickUpModellist = GsonUtil.fromJson(pickUpModelListJson, new TypeToken<List<PickUpInfoModel>>() {
        }.getType());
        PickUpModel pickUp = GsonUtil.fromJson(pickUserJson, PickUpModel.class);
        pickUp.setUserId((String) session.getAttribute("openId"));

        //录入用户信息
        pickUp = pickUpService.insertPickUpModel(pickUp);
        for (PickUpInfoModel pickUpInfoModel : pickUpModellist) {
            //录入用户收件单信息
            pickUpInfoModel.setPickUpId(pickUp.getId());
            pickUpInfoModel.setExpressDate(DateTool.parse(pickUpInfoModel.getExpressDateStr(), DateTool.YYYY_MM_DD_HH_MM));
            pickUpService.insertPickUpInfoModel(pickUpInfoModel);
        }


        return pickUp.getId();
    }

    /**
     * 收件信息详情
     *
     * @param id
     * @param model
     * @param showMsg
     * @return
     */
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


    /**
     * @param searchInput
     * @param request
     * @return
     */
    @RequestMapping("pickUp/getPickUpModel")
    public Object getPickUpModel(String searchInput, HttpServletRequest request) {
        List<PickUpModel> pickUpModelList = pickUpService.getPickUpModel(searchInput);

        if (StringTools.isNotBlank(searchInput)) {
            pickUpModelList = pickUpService.getPickUpModel(searchInput);
        }
        request.setAttribute("pickUpList", pickUpModelList);
        return "/express/query_pick_up";

    }


    /**
     * 查询收件列表
     *
     * @param model
     * @return
     */
    @RequestMapping("pickUp/pick_up_list")
    public String queryPickUpList(Model model) {
        model.addAttribute("pickUpList", pickUpService.getPickUpModelPage(0, 10));
        return "/express/pick_up_list";

    }

    /**
     * 异步分页请求收件列表
     *
     * @param offset
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "pickUp/page", method = RequestMethod.POST)
    public Object queryPickUpListPage(Integer offset, Integer limit) {
        return pickUpService.getPickUpModelPage(offset, limit);
    }


}
