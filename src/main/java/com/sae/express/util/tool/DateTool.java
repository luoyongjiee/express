package com.sae.express.util.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luoqi on 2016-09-18.
 */
public class DateTool {

    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static String format(Date date,String format){
        SimpleDateFormat sdf =  new SimpleDateFormat(format);
        return sdf.format(date);
    }


    public static Date addFiveMinutes(Date date){

        return new Date(date.getTime()+1000L*60L*5L);
    }


    public static Date parse(String date,String format){
        SimpleDateFormat sdf =  new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
           throw new  RuntimeException("时间转换错误");
        }

    }

    public static boolean isInServiceTime(Date date){
        //11:30~13:00或16:30~18:00
        int hour = date.getHours();
        int min = date.getMinutes();

        if(hour == 11){
            if (min>=30) return true;
        }

        if(hour>11&&hour<13){
            return true;
        }

        if(hour==16){
            if (min>=30) return true;
        }

        if(hour>16&&hour<18){
            return true;
        }
        return false;
    }


}
