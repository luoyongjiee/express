package com.sae.express.service.wechat;

import com.sae.express.dao.model.wechat.WeChatPlatform;

/**
 * Created by Administrator on 2016/9/3.
 */
public interface WeChatPlatformService {
    WeChatPlatform getWeChatPlatform(String id);
    WeChatPlatform getAccessTokenById(String openId);
    WeChatPlatform getWeChatPlatformByAppId(String appid);
    boolean updateWeChatPlatform(WeChatPlatform WeChatPlatform);
    boolean saveWeChatPlatform(WeChatPlatform WeChatPlatform);
}
