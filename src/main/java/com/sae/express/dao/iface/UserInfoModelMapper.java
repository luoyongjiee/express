package com.sae.express.dao.iface;

import com.sae.express.dao.model.UserInfoModel;
import com.sae.express.dao.model.UserInfoModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoModelMapper {
    int countByExample(UserInfoModelExample example);

    int deleteByExample(UserInfoModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfoModel record);

    int insertSelective(UserInfoModel record);

    List<UserInfoModel> selectByExample(UserInfoModelExample example);

    UserInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfoModel record, @Param("example") UserInfoModelExample example);

    int updateByExample(@Param("record") UserInfoModel record, @Param("example") UserInfoModelExample example);

    int updateByPrimaryKeySelective(UserInfoModel record);

    int updateByPrimaryKey(UserInfoModel record);
}