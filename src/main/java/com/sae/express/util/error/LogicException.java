package com.sae.express.util.error;

/**
 * Created by luoqi on 2016-10-16.
 */
public class LogicException extends RuntimeException {
    private String code;

    private String msg;

    public LogicException(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
