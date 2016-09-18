package com.sae.express.util.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luoqi on 2016-09-18.
 */
public class DateTool {

    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH-mm";

    public static String format(Date date,String format){
       return "";
    }

    public static Date parse(String date,String format){
        SimpleDateFormat sdf =  new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
           throw new  RuntimeException("时间转换错误");
        }

    }

}
