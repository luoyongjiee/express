package com.sae.express.controller;

import com.sae.express.dao.model.SendInfoModel;
import com.sae.express.dao.model.SendInfoModelExample;
import com.sae.express.dao.model.UserInfoModel;
import com.sae.express.service.ExpressService;
import com.sae.express.util.tool.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    //寄件
    @RequestMapping("addSend")
    @ResponseBody
    public Object addSend(SendInfoModel sendInfo,HttpSession session) {
        String openId = (String) session.getAttribute("openId");
        sendInfo.setUserId(openId);
        SendInfoModel sendInfoModel = expressService.addSend(sendInfo);

        //查询微信是否已有绑定的用户信息，有则更新，没有则插入，并且更新session中存储的用户信息
       /* UserInfoModel userInfoModel = userInfoService.getUserInfoModelByOpenId(openId);
        if (userInfoModel == null) {
            userInfoModel = new UserInfoModel();
            userInfoModel.setBuildingCode(sendInfo.getSenderBuilderNum());
            userInfoModel.setBuildingNum(sendInfo.getSenderRoomNum());
            userInfoModel.setPhone(sendInfo.getSenderPhone());
            userInfoModel.setOpenId(openId);
            userInfoService.insertUserInfoModel(userInfoModel);
        } else {
            userInfoModel.setBuildingCode(sendInfo.getSenderBuilderNum());
            userInfoModel.setBuildingNum(sendInfo.getSenderRoomNum());
            userInfoModel.setPhone(sendInfo.getSenderPhone());
            userInfoService.modifyUserInfoModel(userInfoModel);
        }
        session.setAttribute("wechat_user", userInfoModel);*/
        return sendInfoModel;
    }

    @RequestMapping("addSendMsg")
    public String addSendMsg(String id, HttpServletRequest request) {
        SendInfoModel sendInfo = expressService.getSendInfoModelById(id);
        request.setAttribute("sendInfo", sendInfo);
        return "/express/msg";
    }


    @RequestMapping("getSendInfoModel")
    public String getSendInfoModel(String searchInput, HttpServletRequest request) {

        List<SendInfoModel> sendInfoModelList = null;
        if (StringTools.isNotBlank(searchInput)) {
            sendInfoModelList = expressService.getSendInfoModel(searchInput);
        }

        request.setAttribute("sendInfoModelList", sendInfoModelList);

        return "/express/query_send";
    }

    @RequestMapping("getSendDetail")
    public String getSendDetail(String id, HttpServletRequest request) {
        SendInfoModel sendInfo = expressService.getSendInfoModelById(id);
        request.setAttribute("sendInfo", sendInfo);


        return "/express/send_detail";
    }


    //寄件
    @RequestMapping("query/sendList")
    public String querySendList(String searchInput, Model model){
        model.addAttribute("sendList",expressService.getSendInfoModelPage(new SendInfoModelExample(searchInput,10,0)));
        return "/express/send_list";
    }

    //异步获取寄件列表
    @ResponseBody
    @RequestMapping(value = "query/sendList",method = RequestMethod.POST)
    public List<SendInfoModel> querySendListPage(SendInfoModelExample example){
        return expressService.getSendInfoModelPage(example);
    }
}
