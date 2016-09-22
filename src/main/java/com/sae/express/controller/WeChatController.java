package com.sae.express.controller;

import com.sae.express.dao.model.UserInfoModel;
import com.sae.express.dao.model.wechat.AccessToken;
import com.sae.express.dao.model.wechat.OAuthAccessToken;
import com.sae.express.dao.model.wechat.WeChatPlatform;
import com.sae.express.service.CommonService;
import com.sae.express.service.UserInfoService;
import com.sae.express.service.impl.UserInfoServiceImpl;
import com.sae.express.service.wechat.WeChatPlatformService;
import com.sae.express.util.wechat.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private WeChatPlatformService weChatPlatformService;
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
    @RequestMapping(value = "wechat",method = RequestMethod.POST)
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
    @RequestMapping(value="wechat",method = RequestMethod.GET)
    public Object wechat(String signature,String timestamp,String nonce,String echostr){

        return "wechat";
    }

    @Value("${wechat.public_app_id}")
    private String appid;

    @Value("${wechat.host.uri}")
    private String hostUri;
    @Value("${wechat.public_appsecret}")
    private String appsecret;

    @RequestMapping(value="wechat/redirect",method = RequestMethod.GET)
    public String redirect(String sendRedirect,HttpSession session,Model model){
        model.addAttribute("appid",appid);
        model.addAttribute("hostUri",hostUri);
        model.addAttribute("sendRedirect",sendRedirect);
        return "/express/send_redirect";
    }

    @RequestMapping(value="wechat/getuser",method = RequestMethod.GET)
    public String weChatGetUser( String sendRedirect, String code, String state,HttpSession session){
        System.out.println("sendRedirect:"+sendRedirect+"----------code:"+code);
        if(sendRedirect==null || sendRedirect.equals("") || sendRedirect.contains("wechat/getuser")){
            return "/express/error";
        }
        WeChatPlatform weChatPlatform=weChatPlatformService.getWeChatPlatformByAppid(appid);
        if (weChatPlatform==null){
            weChatPlatform=new WeChatPlatform();
            AccessToken accessToken =WeChatUtil.getAccessToken(appid,appsecret);
            weChatPlatform.setAppId(appid);
            weChatPlatform.setAppSecret(appsecret);
            weChatPlatform.setCreateTime(System.currentTimeMillis());
            weChatPlatform.setAccess_token(accessToken.getToken());
            weChatPlatformService.insertWeChatPlatform(weChatPlatform);
        }
        OAuthAccessToken oAuthAccessToken =  WeChatUtil.getOAuthByCode(appid,appsecret , code);
        String openId=null;
        if(oAuthAccessToken == null){
            return "redriect:/wechat/getuser";
        }else {
            openId= oAuthAccessToken.getOpenid();
            session.setAttribute("openId",openId);
        }

        UserInfoModel userInfoModel=userInfoService.getUserInfoModelByOpenId(openId);
        if(userInfoModel!=null){
            session.setAttribute("wechat_user",userInfoModel);
        }

        return "redriect:"+sendRedirect;
    }

}
