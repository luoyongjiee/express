package com.sae.express.util.commont.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import com.sae.express.dao.model.wechat.AccessToken;
import com.sae.express.dao.model.wechat.JsapiTicket;
import com.sae.express.dao.model.wechat.WeChatPlatform;
import com.sae.express.service.wechat.WeChatPlatformService;
import com.sae.express.util.wechat.WeChatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 定时器执行的定时方法
 *
 */
public class DataStatisticsTemer {
    private static Logger log = LoggerFactory.getLogger(DataStatisticsTemer.class);

    @Autowired
    private static WeChatPlatformService weChatPlatformService;


    /**
     * 获取token
     */
    public static void saveWxPlatform() {
        Calendar calendar = Calendar.getInstance();

        Date time = calendar.getTime();         // 得出执行任务的时间
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            private WeChatPlatform weChatPlatform;
            private AccessToken accessToken = null;
            private JsapiTicket jsapiTicket = null;

            @Override
            public void run() {
                long nowtime = System.currentTimeMillis();
                weChatPlatform = new WeChatPlatform();
                weChatPlatform.setAppId("appID");
                //wxPlatform.setAppSecret(ConstantsUtil.APP_SECRET);
                accessToken = WeChatUtil.getAccessToken("appID", "APP_SECRET");
                if (accessToken != null) {
                    log.info("获取成功：APP_ID" + weChatPlatform.getAppId() + "-->>accessToken:" + accessToken.getToken());
                    weChatPlatform.setAccessToken(accessToken.getToken());
                    //weChatPlatform.setCreateTime(nowtime);
                    weChatPlatformService.modifyWeChatPlatform(weChatPlatform);
                    /*if (!weChatPlatformService.modifyWeChatPlatform(weChatPlatform)) {
                        weChatPlatformService.insertWeChatPlatform(weChatPlatform);
                    }*/
                } else {
                    log.error("获取失败：APP_ID" + weChatPlatform.getAppId());
                }

                weChatPlatform = new WeChatPlatform();
                weChatPlatform.setAppId("appid");
                if (accessToken != null) {
                    log.info("获取成功：PUBLIC_APP_ID" + weChatPlatform.getAppId() + "-->>accessToken:" + accessToken.getToken());

                    accessToken = WeChatUtil.getAccessToken("appid", ".PUBLIC_APP_SECRET");
                    weChatPlatform.setAccessToken(accessToken.getToken());
                    jsapiTicket = WeChatUtil.getJsapiTicket(accessToken.getToken());

                    weChatPlatform.setJsapiTicket(jsapiTicket.getTicket());
                    log.info("获取成功：PUBLIC_APP_ID" + weChatPlatform.getAppId() + "-->>jsapiTicket:" + jsapiTicket.getTicket());
                   // weChatPlatform.setCreateTime(nowtime);
                    weChatPlatformService.modifyWeChatPlatform(weChatPlatform);
                    /*if (!weChatPlatformService.updateWeChatPlatform(weChatPlatform)) {
                        weChatPlatformService.saveWeChatPlatform(weChatPlatform);
                    }*/

                } else {
                    log.error("获取失败：PUBLIC_APP_ID" + weChatPlatform.getAppId());
                }
            }
        }, time, 2 * 55 * 60 * 1000);// 这里设定将延时2个小时固定执行
    }

}
