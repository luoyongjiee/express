package com.sae.express.service.impl;


import com.sae.express.dao.iface.SendInfoModelMapper;
import com.sae.express.dao.model.*;
import com.sae.express.repository.DateRepository;
import com.sae.express.service.ExpressService;
import com.sae.express.util.tool.DateTool;
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
    private DateRepository dateRepository;



    public SendInfoModel addSend(SendInfoModel sendInfo) {
        sendInfo.setStatus(Integer.valueOf(0));
        sendInfo.setCreateTime(DateTool.parse(dateRepository.currentTime(),DateTool.YYYY_MM_DD_HH_MM_SS));
        sendInfo.setUpdateTime(DateTool.parse(dateRepository.currentTime(),DateTool.YYYY_MM_DD_HH_MM_SS));
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

}
