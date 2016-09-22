package com.sae.express.service.wechat;


import com.sae.express.dao.iface.WeChatPlatformMapper;
import com.sae.express.dao.model.wechat.WeChatPlatform;
import com.sae.express.dao.model.wechat.WeChatPlatformExample;
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
    private WeChatPlatformMapper wechatPlatformMapper;

    public WeChatPlatform insertWeChatPlatform(WeChatPlatform weChatPlatform) {
        wechatPlatformMapper.insertSelective(weChatPlatform);
        return weChatPlatform;
    }

    /**
     * 更新公众号信息
     *
     * @param weChatPlatform
     * @return
     */
    public WeChatPlatform modifyWeChatPlatform(WeChatPlatform weChatPlatform) {
        wechatPlatformMapper.updateByPrimaryKey(weChatPlatform);
        return weChatPlatform;
    }

    /**
     * 根据appid 查询公众号信息
     *
     * @param appid
     * @return
     */
    public WeChatPlatform getWeChatPlatformByAppid(String appid) {
        WeChatPlatformExample example = new WeChatPlatformExample();
        WeChatPlatformExample.Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appid);
        //wechatPlatformMapper.selectByappid(appid);
        List<WeChatPlatform> weChatPlatforms = wechatPlatformMapper.selectByExample(example);
        return weChatPlatforms.isEmpty() ? null : weChatPlatforms.get(0);
    }
}
