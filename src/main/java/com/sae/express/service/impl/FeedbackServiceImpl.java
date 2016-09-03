package com.sae.express.service.impl;

import com.sae.express.dao.iface.FeedbackModelMapper;
import com.sae.express.dao.model.FeedbackModel;
import com.sae.express.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by luoqi on 2016-09-03.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    private FeedbackModelMapper feedbackModelMapper;

    public int addFeedback(FeedbackModel feedbackModel) {
        feedbackModel.setCreateTime(new Date());
        return feedbackModelMapper.insertSelective(feedbackModel);
    }

}
