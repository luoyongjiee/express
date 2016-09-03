package com.sae.express.controller;

import com.sae.express.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sae.express.service.wechat.CoreService;
import com.sae.express.util.wechat.SignUtil;

/**
 * Created by luoqi on 2016-08-09.
 */
@Controller
public class WeChatController {
    //private final static String TOKEN = "wechat_token";
    @Autowired
    private CommonService commonService;
    @Autowired
    private CoreService coreService;
    /**
     * 确认请求来自微信服务器
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "wechat/accessWeChat",method = RequestMethod.GET)
    public void accessWeChatGet(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        System.out.println("request=" + request.getRequestURL());
        if(signature!=null&&timestamp!=null&&nonce!=null&&echostr!=null){
            PrintWriter out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                out.print(echostr);
            }
            out.close();
            out = null;
        }
    }


    /**
     * 处理微信服务器发来的消息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "wechat/accessWeChat",method = RequestMethod.POST)
    public void accessWeChatPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 调用核心业务类接收消息、处理消息
        String respMessage = coreService.processRequest(request);
        System.out.println("respMessage=" + respMessage);
        // 响应消息
        if(respMessage != null){
            PrintWriter out = response.getWriter();
            out.print(respMessage);
            out.close();
        }
    }


    @ResponseBody
    @RequestMapping(value="wechat")
    public Object wechat(String signature,String timestamp,String nonce,String echostr){

        return "wechat";
    }


}
