package com.sae.express.util.commont.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TaskManager implements ServletContextListener {
	private static Logger log = LoggerFactory.getLogger(TaskManager.class);
    /**   
     * 在Web应用启动时初始化任务   
     */   
    public void contextInitialized(ServletContextEvent event) {    
        //启动定时获取access_token的线程
    	DataStatisticsTemer.saveWxPlatform();
    	log.info("获取token线程已启动");
    }    
    /**   
     * 在Web应用结束时停止任务   
     */   
    public void contextDestroyed(ServletContextEvent event) {
			log.info("thread:线程已结束");
    	
    }    
   }  