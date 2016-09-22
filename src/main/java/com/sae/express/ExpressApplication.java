package com.sae.express;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by luoqi on 2016-08-06.
 */
@SpringBootApplication
@ImportResource("classpath*:/mybatis.xml")
public class ExpressApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(ExpressApplication.class, args);
    }

}
