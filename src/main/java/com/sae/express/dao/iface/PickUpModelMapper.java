package com.sae.express.dao.iface;

import com.sae.express.dao.model.PickUpModel;
import com.sae.express.dao.model.PickUpModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PickUpModelMapper {
    int countByExample(PickUpModelExample example);

    int deleteByExample(PickUpModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PickUpModel record);

    int insertSelective(PickUpModel record);

    List<PickUpModel> selectByExample(PickUpModelExample example);

    PickUpModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PickUpModel record, @Param("example") PickUpModelExample example);

    int updateByExample(@Param("record") PickUpModel record, @Param("example") PickUpModelExample example);

    int updateByPrimaryKeySelective(PickUpModel record);

    int updateByPrimaryKey(PickUpModel record);
}