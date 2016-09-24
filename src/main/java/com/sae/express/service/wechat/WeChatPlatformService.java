package com.sae.express.service.wechat;

import com.sae.express.dao.model.wechat.WeChatPlatform;

/**
 * Created by Administrator on 2016/9/3.
 */
public interface WeChatPlatformService {
    /**
     * 插入公众号信息
     *
     * @param weChatPlatform
     * @return
     */
    WeChatPlatform insertWeChatPlatform(WeChatPlatform weChatPlatform);

    /**
     * 更新公众号信息
     *
     * @param weChatPlatform
     * @return
     */
    WeChatPlatform modifyWeChatPlatform(WeChatPlatform weChatPlatform);

    /**
     * 根据公众号appid获取公众号信息
     *
     * @param appid
     * @return
     */
    WeChatPlatform getWeChatPlatformByAppid(String appid);
}
