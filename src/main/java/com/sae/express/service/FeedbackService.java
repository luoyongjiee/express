package com.sae.express.service;

import com.sae.express.dao.model.FeedbackModel;

import java.util.List;

/**
 * Created by luoqi on 2016-09-03.
 */
public interface FeedbackService {

    int addFeedback(FeedbackModel feedbackModel);

    List<FeedbackModel> listFeedback(Integer offset,Integer limit);
}
