package com.sae.express.dao.iface;

import com.sae.express.dao.model.wechat.WeChatPlatform;
import com.sae.express.dao.model.wechat.WeChatPlatformExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WeChatPlatformMapper {
    int countByExample(WeChatPlatformExample example);

    int deleteByExample(WeChatPlatformExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WeChatPlatform record);

    int insertSelective(WeChatPlatform record);

    List<WeChatPlatform> selectByExample(WeChatPlatformExample example);

    WeChatPlatform selectByPrimaryKey(Integer id);
    WeChatPlatform selectByappid(String appid);

    int updateByExampleSelective(@Param("record") WeChatPlatform record, @Param("example") WeChatPlatformExample example);

    int updateByExample(@Param("record") WeChatPlatform record, @Param("example") WeChatPlatformExample example);

    int updateByPrimaryKeySelective(WeChatPlatform record);

    int updateByPrimaryKey(WeChatPlatform record);
}