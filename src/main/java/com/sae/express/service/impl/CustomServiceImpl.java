package com.sae.express.service.impl;

import com.sae.express.dao.iface.CustomMsgModelMapper;
import com.sae.express.dao.model.CustomMsgModel;
import com.sae.express.dao.model.CustomMsgModelExample;
import com.sae.express.service.CustomService;
import com.sae.express.util.tool.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luoqi on 2016-10-24.
 */
@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    private CustomMsgModelMapper customMsgModelMapper;



    @Override
    public List<CustomMsgModel> getgetCustomMsgModel(String msg) {
        CustomMsgModelExample example = new CustomMsgModelExample();
        if(StringTools.isNotBlank(msg)){
            CustomMsgModelExample.Criteria criteria = example.createCriteria();
            msg = msg.trim();
            criteria.andKeywordLike("%"+msg+"%");
        }

        return customMsgModelMapper.selectByExample(example);
    }


    public CustomMsgModel getCustomMsgModelById(Integer id) {
        return customMsgModelMapper.selectByPrimaryKey(id);
    }
}
