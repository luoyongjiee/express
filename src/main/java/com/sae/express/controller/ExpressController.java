package com.sae.express.controller;

import com.sae.express.dao.model.SendInfoModel;
import com.sae.express.dao.model.UserInfoModel;
import com.sae.express.service.ExpressService;
import com.sae.express.service.PickUpService;
import com.sae.express.service.UserInfoService;
import com.sae.express.util.tool.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * Created by luoqi on 2016-08-14.
 */
@Controller
public class ExpressController {

    @Autowired
    private ExpressService expressService;

    @Autowired
    private PickUpService pickUpService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/path/{folder}/{file}")
    public String path(@PathVariable("folder") String folder, @PathVariable("file") String file) {
        return "/" + folder + "/" + file;
    }


    /**
     * 寄件
     *
     * @param sendInfo
     * @param session
     * @return
     */
    @RequestMapping("addSend")
    @ResponseBody
    public Object addSend(SendInfoModel sendInfo,HttpSession session) {
        String openId = (String) session.getAttribute("openId");
        sendInfo.setUserId(openId);
        SendInfoModel sendInfoModel = expressService.addSend(sendInfo);

        //查询微信是否已有绑定的用户信息，有则更新，没有则插入，并且更新session中存储的用户信息
        UserInfoModel userInfoModel = userInfoService.getUserInfoModelByOpenId(openId);
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
        session.setAttribute("wechat_user", userInfoModel);
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

}
