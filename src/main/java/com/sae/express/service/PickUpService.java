package com.sae.express.service;

import com.sae.express.dao.model.PickUpInfoModel;
import com.sae.express.dao.model.PickUpModel;
import com.sae.express.dao.model.PickUpModelExample;

import java.util.List;

/**
 * Created by luoqi on 2016-09-19.
 */
public interface PickUpService {

    PickUpModel insertPickUpModel(PickUpModel pickUpModel);

    PickUpInfoModel insertPickUpInfoModel(PickUpInfoModel pickUpInfoModel);


    PickUpModel getPickUpModelById(Integer id);

    List<PickUpInfoModel> getPickUpInfoModelList(Integer pickUpId);

    List<PickUpModel> getPickUpModel(String search);

    List<PickUpModel> getPickUpModelPage(Integer offset,Integer limit);

    int updatePickUpStatus(Integer pickUpId,String status);

    List<PickUpModel> showPickUpModel(List<PickUpInfoModel> pickUpInfoModelList);

    int updatePickUpOrderStatus(Integer pickUpId,String status);

    List<PickUpModel> getPickUpModelByUserId(String userId);

    List<PickUpInfoModel> getPickUpInfoModelList(String date, String express);
}
