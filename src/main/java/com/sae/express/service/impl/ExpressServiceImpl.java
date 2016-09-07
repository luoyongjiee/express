package com.sae.express.service.impl;

import com.sae.express.dao.iface.PickUpMapper;
import com.sae.express.dao.iface.PickUpModelMapper;
import com.sae.express.dao.iface.SendInfoModelMapper;
import com.sae.express.dao.model.*;
import com.sae.express.service.ExpressService;
import com.sae.express.util.tool.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by luoqi on 2016-08-23.
 */
@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private SendInfoModelMapper sendInfoModelMapper;

    @Autowired
    private PickUpModelMapper pickUpModelMapper;
    @Autowired
    private PickUpMapper pickUpMapper;

    public SendInfoModel addSend(SendInfoModel sendInfo) {
        sendInfo.setStatus(Integer.valueOf(0));
        sendInfo.setCreateTime(new Date());
        sendInfo.setUpdateTime(new Date());
         sendInfoModelMapper.insertSelective(sendInfo);
        return sendInfo;
    }

    public  SendInfoModel getSendInfoModelById(String id){
        return sendInfoModelMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    public List<SendInfoModel> getSendInfoModel(String searchInfo){
        SendInfoModelExample example = new SendInfoModelExample();
        if(StringTools.isNotBlank(searchInfo)){
            if(StringTools.isNumber(searchInfo)&&searchInfo.length()<6){
                SendInfoModelExample.Criteria criteria1 = example.or();
                criteria1.andIdEqualTo(Integer.valueOf(searchInfo));
            }else{
                SendInfoModelExample.Criteria criteria2 = example.or();
                criteria2.andSenderNameEqualTo(searchInfo);
            }

        }

        return sendInfoModelMapper.selectByExample(example);
    }

    public List<SendInfoModel> getSendInfoModelPage(SendInfoModelExample example){
        example.setOrderByClause("create_time desc");
        return sendInfoModelMapper.selectByExample(example);
    }

    public List<PickUpModel> getPickUpModelPage(PickUpModelExample example){
        return pickUpModelMapper.selectByExample(example);
    }
    public PickUpModel insertPickUpModel(PickUpModel pickUpModel) {
        pickUpModel.setCreateTime(new Date());
        pickUpModel.setUpdateTime(new Date());
        pickUpModelMapper.insertSelective(pickUpModel);
        return pickUpModel;
    }
    public PickUp insertPickUp(PickUp pickUp) {
        pickUp.setCreateTime(new Date());
        pickUpMapper.insertSelective(pickUp);
        return pickUp;
    }

}
