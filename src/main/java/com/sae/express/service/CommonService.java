package com.sae.express.service;

/**
 * Created by luoqi on 2016-08-09.
 */
public interface CommonService {
    /**
     * 验证推送过来的消息的正确性
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    boolean checkSignature(String token,String timestamp, String nonce, String signature);
}
