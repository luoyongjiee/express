package com.sae.express.service.wechat;

import com.sae.express.dao.model.wechat.WeChatPlatform;

/**
 * Created by Administrator on 2016/9/3.
 */
public interface WeChatPlatformService {
    WeChatPlatform insertWeChatPlatform(WeChatPlatform weChatPlatform);

    WeChatPlatform modifyWeChatPlatform(WeChatPlatform weChatPlatform);
    WeChatPlatform getWeChatPlatformByAppid(String appid) ;
}
