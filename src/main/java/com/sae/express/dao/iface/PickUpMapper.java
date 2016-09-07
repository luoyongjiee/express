package com.sae.express.dao.iface;

import com.sae.express.dao.model.PickUp;
import com.sae.express.dao.model.PickUpModel;
import com.sae.express.dao.model.PickUpModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PickUpMapper {
    int countByExample(PickUp pickUp);

    int insert(PickUp pickUp);

    int insertSelective(PickUp pickUp);

    List<PickUp> selectByExample(PickUp pickUp);

}