package com.sae.express.util;

import com.sae.express.util.crypto.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by luoqi on 2016-10-15.
 */
public class SignatureUtil {

    private static Logger log = LoggerFactory.getLogger(SignatureUtil.class);

    /**
     * 签名算法
     * @param obj 要参与签名的数据对象
     * @param key apiKey
     * @return 签名
     * @throws IllegalAccessException
     */
    public static String getSign(Object obj,String key) throws IllegalAccessException {
        ArrayList<String> list = new ArrayList<String>();
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.get(obj) != null && f.get(obj) != "") {
                list.add(f.getName() + "=" + f.get(obj) + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + key;
        log.info("Sign Before MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        return result;
    }

    public static String getSign(Map<String,Object> map,String key){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            if(entry.getValue()!=""){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + key;
        log.info("Sign Before MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();

        return result;
    }

}
