package com.sae.express.config;

import com.sae.express.dao.model.WechatPlatformModel;
import com.sae.express.dao.model.wechat.AccessToken;
import com.sae.express.dao.model.wechat.JsapiTicket;
import com.sae.express.service.WeChatPlatformService;
import com.sae.express.util.wechat.WeChatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author： Administrator
 * @Date ： 2016/9/24. 14:35
 *
 * 定时器 ：
 * 1、定时更新WeChatPlatform的accesstoken
 */
@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {
    private static Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private WeChatPlatformService weChatPlatformService;

    @Value("${wechat.public_appsecret}")
    private String appsecret;

    @Value("${wechat.public_app_id}")
    private String appid;

    /**
     * 定时器：定时更新公众号的信息，两小时运行一次
     */
    @Scheduled(cron = "0 0 */2 * * *")
    public void reportCurrentByCron(){
        log.info("定时器正常运行");
        WechatPlatformModel weChatPlatform = weChatPlatformService.getWeChatPlatformByAppid(appid);
        if (weChatPlatform==null){
            weChatPlatform = new WechatPlatformModel();
        }
        AccessToken accessToken  = WeChatUtil.getAccessToken(appid, appsecret);
        if (accessToken != null) {
            JsapiTicket jsapiTicket = WeChatUtil.getJsapiTicket(accessToken.getToken());
            weChatPlatform.setJsapiTicket(jsapiTicket.getTicket());
            weChatPlatform.setAccessToken(accessToken.getToken());
            log.info("获取成功：APP_ID" + weChatPlatform.getAppId() + "-->>accessToken:" + accessToken.getToken());
           if (weChatPlatform.getAppId()==null){
               weChatPlatform.setAppId(appid);
               weChatPlatform.setAppSecret(appsecret);
               weChatPlatformService.insertWeChatPlatform(weChatPlatform);
           }else {
               weChatPlatformService.modifyWeChatPlatform(weChatPlatform);
           }
            log.info("-->>jsapiTicket:"+jsapiTicket.getTicket());
        } else {
            log.error("获取失败!" );
        }
    }
}
