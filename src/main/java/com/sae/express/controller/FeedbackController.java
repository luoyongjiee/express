package com.sae.express.controller;

import com.sae.express.dao.model.FeedbackModel;
import com.sae.express.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by luoqi on 2016-09-03.
 */
@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/feedback/addFeddback")
    @ResponseBody
    public Object addFeedback(FeedbackModel feedbackModel){
      return feedbackService.addFeedback(feedbackModel);
    }


    @RequestMapping("/feedback/listFeedback")
    @ResponseBody
    public Object listFeedback(Integer offset,Integer limit){
        Map<String,Object> result = new HashMap<String, Object>();

        result.put("list",feedbackService.listFeedback(offset, limit));
        result.put("count",feedbackService.countFeedback());
        return result;
    }

    @RequestMapping("/feedback/showFeedback")
    public String showFeedback(Integer id,HttpServletRequest request){

        request.setAttribute("feedback",feedbackService.getFeedbackModel(id));
        return "/express/feedbackDetail";
    }

}
