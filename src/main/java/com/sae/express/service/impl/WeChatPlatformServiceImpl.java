package com.sae.express.service.impl;



import com.sae.express.dao.iface.WechatPlatformModelMapper;
import com.sae.express.dao.model.WechatPlatformModel;
import com.sae.express.dao.model.WechatPlatformModelExample;
import com.sae.express.service.WeChatPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 * 公众号信息操作业务
 */
@Service
public class WeChatPlatformServiceImpl implements WeChatPlatformService {

    @Autowired
    private WechatPlatformModelMapper wechatPlatformModelMapper;

    public WechatPlatformModel insertWeChatPlatform(WechatPlatformModel weChatPlatform) {
        wechatPlatformModelMapper.insertSelective(weChatPlatform);
        return weChatPlatform;
    }


    public WechatPlatformModel modifyWeChatPlatform(WechatPlatformModel weChatPlatform) {
        wechatPlatformModelMapper.updateByPrimaryKey(weChatPlatform);
        return weChatPlatform;
    }


    public WechatPlatformModel getWeChatPlatformByAppid(String appid) {
        WechatPlatformModelExample example = new WechatPlatformModelExample();
        WechatPlatformModelExample.Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appid);
        List<WechatPlatformModel> weChatPlatforms = wechatPlatformModelMapper.selectByExample(example);
        return weChatPlatforms.isEmpty() ? null : weChatPlatforms.get(0);
    }
}
