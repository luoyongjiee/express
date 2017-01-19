package com.sae.express.controller;

import com.sae.express.repository.DateRepository;
import com.sae.express.service.ExpressService;
import com.sae.express.service.PickUpService;
import com.sae.express.service.UserInfoService;
import com.sae.express.util.tool.DateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by luoqi on 2016-08-14.
 */
@Controller
public class ExpressController {
    Logger logger = LoggerFactory.getLogger(ExpressController.class);
    @Autowired
    private ExpressService expressService;

    @Autowired
    private PickUpService pickUpService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private DateRepository dateRepository;

    @RequestMapping("/path/{folder}/{file}")
    public String path(@PathVariable("folder") String folder, @PathVariable("file") String file) {


        if("pick_up_order".equals(file)){
            Date now =DateTool.parse(dateRepository.currentTime(), DateTool.YYYY_MM_DD_HH_MM_SS);
            logger.info("现在的小时"+now.getHours());
            /*if(now.getHours()>=19){
                return "/express/stopMsg";
            }*/
            return "/express/holidayMsg";
        }

        return "/" + folder + "/" + file;
    }



}
