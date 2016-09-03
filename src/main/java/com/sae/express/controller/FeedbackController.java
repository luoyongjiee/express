package com.sae.express.controller;

import com.sae.express.dao.model.FeedbackModel;
import com.sae.express.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by luoqi on 2016-09-03.
 */
@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value = "/feedback/addFeddback")
    @ResponseBody
    public Object addFeedback(FeedbackModel feedbackModel){
      return feedbackService.addFeedback(feedbackModel);
    }


}
