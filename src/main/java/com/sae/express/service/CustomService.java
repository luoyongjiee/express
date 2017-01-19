package com.sae.express.service;

import com.sae.express.dao.model.CustomMsgModel;

import java.util.List;

/**
 * Created by luoqi on 2016-10-24.
 */
public interface CustomService {
    List<CustomMsgModel> getgetCustomMsgModel(String msg);

    CustomMsgModel getCustomMsgModelById(Integer id);
}
