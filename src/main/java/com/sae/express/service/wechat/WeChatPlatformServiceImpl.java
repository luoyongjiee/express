package com.sae.express.service.wechat;


import com.sae.express.dao.iface.WechatPlatformMapper;
import com.sae.express.dao.model.wechat.AccessToken;
import com.sae.express.dao.model.wechat.WeChatPlatform;
import com.sae.express.service.wechat.WeChatPlatformService;
import com.sae.express.util.wechat.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/3.
 * 公众号信息操作业务
 */
@Service
public class WeChatPlatformServiceImpl implements WeChatPlatformService {
    @Autowired
    private WechatPlatformMapper wechatPlatformMapper;

    public WeChatPlatform getWeChatPlatform(String id){
       /* return wechatPlatformMapper.getById(id);*/
        return null;
    }

    /**
     * 获取accessToken
     * @param openId
     * @return
     */
    public WeChatPlatform getAccessTokenById(String openId){
        /*return wechatPlatformMapper.getAccessTokenById(openId);*/
        return null;
    }

    /**
     * 获取公众号信息
     * @param appid
     * @return
     */
    public WeChatPlatform getWeChatPlatformByAppId(String appid){
        /*WeChatPlatform WeChatPlatform = wechatPlatformMapper.getById(appid);
        if(WeChatPlatform == null){
            //TODO PUBLIC_APP_SECRET替换
            AccessToken accessToken = WeChatUtil.getAccessToken(appid,"PUBLIC_APP_SECRET");
            WeChatPlatform = new WeChatPlatform();
            WeChatPlatform.setAppId(appid);
            WeChatPlatform.setAccess_token(accessToken.getToken());
           *//* wechatPlatformMapper.save(WeChatPlatform);*//*
        }
        return WeChatPlatform;*/
        return null;
    }

    public boolean updateWeChatPlatform(WeChatPlatform WeChatPlatform){
       /* return wechatPlatformMapper.update(WeChatPlatform);*/
        return true;
    }

    public boolean saveWeChatPlatform(WeChatPlatform WeChatPlatform){
        /*WeChatPlatform.setCreateTime(System.currentTimeMillis());
        return wechatPlatformMapper.save(WeChatPlatform);*/
        return false;
    }

}
