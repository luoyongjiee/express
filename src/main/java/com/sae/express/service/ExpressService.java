package com.sae.express.service;

import com.sae.express.dao.model.SendInfoModel;

import java.util.List;

/**
 * Created by luoqi on 2016-08-23.
 */
public interface ExpressService {
   SendInfoModel addSend(SendInfoModel sendInfo);

   SendInfoModel getSendInfoModelById(String id);

   List<SendInfoModel> getSendInfoModel(String searchInfo);
}
