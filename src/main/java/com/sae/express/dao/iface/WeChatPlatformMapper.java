package com.sae.express.dao.iface;

import com.sae.express.dao.model.wechat.WeChatPlatform;

/**
 * Created by Administrator on 2016/9/3.
 */
public interface WeChatPlatformMapper {
    WeChatPlatform getById(String id);
    WeChatPlatform getAccessTokenById(String openId);
    boolean save(WeChatPlatform t);
    boolean update(WeChatPlatform t);
}
