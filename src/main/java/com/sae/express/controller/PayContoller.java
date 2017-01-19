package com.sae.express.controller;

import com.sae.express.dao.model.PickUpModel;
import com.sae.express.repository.DateRepository;
import com.sae.express.service.PayService;
import com.sae.express.service.PickUpService;
import com.sae.express.util.Configure;
import com.sae.express.util.IPUtils;
import com.sae.express.util.constant.CommonCode;
import com.sae.express.util.tool.DateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by luoqi on 2016-10-15.
 */
@Controller
public class PayContoller {
    private Logger log = LoggerFactory.getLogger(PayContoller.class);

    @Autowired
    private PayService payService;

    @Autowired
    private PickUpService pickUpService;

    @Autowired
    private DateRepository dateRepository;

    @RequestMapping(value = "pay/nakeOrder")
    public String makeOrder(HttpServletRequest request, HttpSession session, Integer pickUpId) throws IllegalAccessException {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            PickUpModel pickUpModel = pickUpService.getPickUpModelById(pickUpId);
            String totalFee = Integer.toString(pickUpModel.getMoney());

            String createIp = IPUtils.getIpAddr(request);
            String openid = (String) session.getAttribute("openId");
            resultMap = payService.makeOrder(pickUpId, totalFee, createIp, openid);
            resultMap.put("totalFee", totalFee);
            resultMap.put("pickUpId", pickUpId);
            resultMap.put("code", CommonCode.SUCCESS_CODE);
        } catch (Exception ex) {
            resultMap.put("code", CommonCode.FAILURE_CODE);
            resultMap.put("msg", "支付失败!");
        }
        log.info("result---"+resultMap.get("code")+"    "+resultMap.get("totalFee"));
        request.setAttribute("result", resultMap);
        return "express/pay";
    }


    @ResponseBody
    @RequestMapping("pay/notifyResult/{pickUpId}")
    public Object notifyResult(@PathVariable("pickUpId") Integer pickUpId) {
        return pickUpService.updatePickUpStatus(pickUpId,"1");
    }

    @ResponseBody
    @RequestMapping("pay/refund")
    public Object refund(Integer pickUpId){
        Map<String,String> resultMap = payService.refund(pickUpId);
        String code = resultMap.get("code");

        if(CommonCode.FAILURE_CODE.equals(code)){
            pickUpService.updatePickUpOrderStatus(pickUpId,"6");
        }else{
            pickUpService.updatePickUpOrderStatus(pickUpId,"5");
        }
        return resultMap;
    }


    @ResponseBody
    @RequestMapping("pay/time")
    public Object time(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("date",dateRepository.currentDate());
        result.put("time",dateRepository.currentTime());
        result.put("time1", DateTool.parse(dateRepository.currentTime(),DateTool.YYYY_MM_DD_HH_MM_SS));

        return result;
    }

    @ResponseBody
    @RequestMapping("pay/certpath")
    public Object certpath(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("certpath", Configure.certLocalPath);
        File file = new File(Configure.certLocalPath);
        result.put("exist",file.exists());
        return result;
    }


}
