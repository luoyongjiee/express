package com.sae.express.service.impl;

import com.sae.express.dao.iface.PickUpInfoModelMapper;
import com.sae.express.dao.iface.PickUpModelMapper;
import com.sae.express.dao.iface.UserInfoModelMapper;
import com.sae.express.dao.model.*;
import com.sae.express.service.PickUpService;
import com.sae.express.service.UserInfoService;
import com.sae.express.util.tool.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by luoqi on 2016-09-19.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoModelMapper userInfoModelMapper;

    /**
     * 插入一条用户信息
     *
     * @param userInfoModel
     * @return
     */
    public UserInfoModel insertUserInfoModel(UserInfoModel userInfoModel) {
        userInfoModelMapper.insertSelective(userInfoModel);
        return userInfoModel;
    }

    /**
     * 根据主键查询单用户信息
     *
     * @param id
     * @return
     */
    public UserInfoModel getUserInfoModelById(Integer id) {
        return userInfoModelMapper.selectByPrimaryKey(id);
    }


    /**
     * 根据openId查询用户信息
     *
     * @param opendId
     * @return
     */
    public UserInfoModel getUserInfoModelByOpenId(String opendId) {
        UserInfoModelExample example = new UserInfoModelExample();
        UserInfoModelExample.Criteria criteria = example.createCriteria();
        criteria.andOpenidEqualTo(opendId);

        List<UserInfoModel> userInfoModels = userInfoModelMapper.selectByExample(example);
        return userInfoModels.isEmpty() ? null : userInfoModels.get(0);
    }

    /**
     * 根据openId查询用户信息
     *
     * @param opendId
     * @return
     */
    public List<UserInfoModel> getUserInfoModellList(String opendId) {
        UserInfoModelExample example = new UserInfoModelExample();
        UserInfoModelExample.Criteria criteria = example.createCriteria();
        criteria.andOpenidEqualTo(opendId);

        return userInfoModelMapper.selectByExample(example);
    }

    /**
     * 分页查询
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<UserInfoModel> getUserInfoModelPage(Integer offset, Integer limit) {
        UserInfoModelExample example = new UserInfoModelExample();
        example.setOffset(offset);
        example.setLimit(limit);
        return userInfoModelMapper.selectByExample(example);
    }


}
