package com.sae.express.service;


import java.util.Map;

/**
 * Created by luoqi on 2016-10-16.
 */
public interface PayService {

    Map<String,Object> makeOrder(Integer pickUpId,String totalFee,String createIp,String openid) throws IllegalAccessException;

    Map<String,String> refund(Integer pickUpId);
}
