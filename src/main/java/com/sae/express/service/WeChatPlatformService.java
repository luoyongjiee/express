package com.sae.express.service;


import com.sae.express.dao.model.WechatPlatformModel;

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
    WechatPlatformModel insertWeChatPlatform(WechatPlatformModel weChatPlatform);

    /**
     * 更新公众号信息
     *
     * @param weChatPlatform
     * @return
     */
    WechatPlatformModel modifyWeChatPlatform(WechatPlatformModel weChatPlatform);

    /**
     * 根据公众号appid获取公众号信息
     *
     * @param appid
     * @return
     */
    WechatPlatformModel getWeChatPlatformByAppid(String appid);
}
