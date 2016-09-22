package com.sae.express.service;

import com.sae.express.dao.model.PickUpInfoModel;
import com.sae.express.dao.model.PickUpModel;
import com.sae.express.dao.model.UserInfoModel;

import java.util.List;

/**
 * Created by luoqi on 2016-09-19.
 */
public interface UserInfoService {

    UserInfoModel insertUserInfoModel(UserInfoModel userInfoModel);

    UserInfoModel getUserInfoModelById(Integer id);

    UserInfoModel getUserInfoModelByOpenId(String opendId);

    List<UserInfoModel> getUserInfoModellList(String pickUpId);

    List<UserInfoModel> getUserInfoModelPage(Integer offset, Integer limit);
}
