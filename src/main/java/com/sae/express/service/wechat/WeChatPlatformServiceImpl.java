package com.sae.express.service.wechat;

import com.sae.express.dao.iface.WeChatPlatformMapper;
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
    private WeChatPlatformMapper sendInfoModelMapper;

    public WeChatPlatform getWeChatPlatform(String id){
        return sendInfoModelMapper.getById(id);
    }

    /**
     * 获取accessToken
     * @param openId
     * @return
     */
    public WeChatPlatform getAccessTokenById(String openId){
        return sendInfoModelMapper.getAccessTokenById(openId);
    }

    /**
     * 获取公众号信息
     * @param appid
     * @return
     */
    public WeChatPlatform getWeChatPlatformByAppId(String appid){
        WeChatPlatform WeChatPlatform = sendInfoModelMapper.getById(appid);
        if(WeChatPlatform == null){
            //TODO PUBLIC_APP_SECRET替换
            AccessToken accessToken = WeChatUtil.getAccessToken(appid,"PUBLIC_APP_SECRET");
            WeChatPlatform = new WeChatPlatform();
            WeChatPlatform.setAppId(appid);
            WeChatPlatform.setAccess_token(accessToken.getToken());
            sendInfoModelMapper.save(WeChatPlatform);
        }
        return WeChatPlatform;
    }

    public boolean updateWeChatPlatform(WeChatPlatform WeChatPlatform){
        return sendInfoModelMapper.update(WeChatPlatform);
    }

    public boolean saveWeChatPlatform(WeChatPlatform WeChatPlatform){
        WeChatPlatform.setCreateTime(System.currentTimeMillis());
        return sendInfoModelMapper.save(WeChatPlatform);
    }

}
