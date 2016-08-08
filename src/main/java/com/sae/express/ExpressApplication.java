package com.sae.express;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by luoqi on 2016-08-06.
 */
@SpringBootApplication
public class ExpressApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(ExpressApplication.class, args);
    }
}
