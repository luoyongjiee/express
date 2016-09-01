package com.sae.express.dao.iface;

import com.sae.express.dao.model.SendInfoModel;
import com.sae.express.dao.model.SendInfoModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SendInfoModelMapper {
    int countByExample(SendInfoModelExample example);

    int deleteByExample(SendInfoModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SendInfoModel record);

    int insertSelective(SendInfoModel record);

    List<SendInfoModel> selectByExampleWithRowbounds(SendInfoModelExample example, RowBounds rowBounds);

    List<SendInfoModel> selectByExample(SendInfoModelExample example);

    SendInfoModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SendInfoModel record, @Param("example") SendInfoModelExample example);

    int updateByExample(@Param("record") SendInfoModel record, @Param("example") SendInfoModelExample example);

    int updateByPrimaryKeySelective(SendInfoModel record);

    int updateByPrimaryKey(SendInfoModel record);
}