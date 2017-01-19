package com.sae.express.util;

/**
 * Created by luoqi on 2016-11-01.
 */
public class Configure {
    public static String certPassword = "1376951002";

    public static String certLocalPath;

    static {
        certLocalPath =  Configure.class.getClassLoader().getResource("").getPath()+"apiclient_cert.p12";
    }

}
