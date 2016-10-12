package com.sae.express.service.impl;

import com.sae.express.dao.iface.AdminInfoModelMapper;
import com.sae.express.dao.model.AdminInfoModelExample;
import com.sae.express.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luoqi on 2016-09-27.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminInfoModelMapper adminInfoModelMapper;

    public boolean login(String userId, String password) {
        AdminInfoModelExample example = new AdminInfoModelExample();
        AdminInfoModelExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andPasswordEqualTo(password);
        return adminInfoModelMapper.countByExample(example)>0;
    }
}
