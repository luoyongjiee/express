package com.sae.express.repository.impl;

import com.sae.express.dao.iface.DateModelMapper;
import com.sae.express.repository.DateRepository;
import com.sae.express.util.tool.DateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by luoqi on 2016-10-31.
 */
@Component
public class DateRepositoryImpl implements DateRepository{

    @Autowired
    private DateModelMapper dateModelMapper;

    public String currentTime() {
        return dateModelMapper.currentTime();
    }


    public String currentDate() {
        return dateModelMapper.currentDate();
    }
}
