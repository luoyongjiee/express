package com.sae.express;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpEncodingProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by luoqi on 2016-08-06.
 */
@SpringBootApplication
@ImportResource("classpath*:/mybatis.xml")
public class ExpressApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(ExpressApplication.class, args);
    }



  /*  @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }*/
}
