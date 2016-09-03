package com.sae.express.dao.iface;

import com.sae.express.dao.model.WechatPlatform;
import com.sae.express.dao.model.WechatPlatformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatPlatformMapper {
    int countByExample(WechatPlatformExample example);

    int deleteByExample(WechatPlatformExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatPlatform record);

    int insertSelective(WechatPlatform record);

    List<WechatPlatform> selectByExample(WechatPlatformExample example);

    WechatPlatform selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatPlatform record, @Param("example") WechatPlatformExample example);

    int updateByExample(@Param("record") WechatPlatform record, @Param("example") WechatPlatformExample example);

    int updateByPrimaryKeySelective(WechatPlatform record);

    int updateByPrimaryKey(WechatPlatform record);
}