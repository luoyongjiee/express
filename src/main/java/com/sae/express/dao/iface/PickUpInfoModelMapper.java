package com.sae.express.dao.iface;

import com.sae.express.dao.model.PickUpInfoModel;
import com.sae.express.dao.model.PickUpInfoModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PickUpInfoModelMapper {
    int countByExample(PickUpInfoModelExample example);

    int deleteByExample(PickUpInfoModelExample example);

    int insert(PickUpInfoModel record);

    int insertSelective(PickUpInfoModel record);

    List<PickUpInfoModel> selectByExample(PickUpInfoModelExample example);

    int updateByExampleSelective(@Param("record") PickUpInfoModel record, @Param("example") PickUpInfoModelExample example);

    int updateByExample(@Param("record") PickUpInfoModel record, @Param("example") PickUpInfoModelExample example);
}