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
            @Override
            public void run() {

            }
        }, time, 2 * 55 * 60 * 1000);// 这里设定将延时2个小时固定执行
    }

}
