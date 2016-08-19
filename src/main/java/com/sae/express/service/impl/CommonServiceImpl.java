package com.sae.express.service.impl;

import com.sae.express.service.CommonService;
import com.sae.express.util.StringTools;
import com.sae.express.util.crypto.SHA1;
import org.springframework.stereotype.Service;

/**
 * Created by luoqi on 2016-08-09.
 */
@Service
public class CommonServiceImpl implements CommonService {

    public boolean checkSignature(String token, String timestamp, String nonce, String signature) {
        if(StringTools.isBlank(signature)){
            return false;
        }
        if(StringTools.isBlank(timestamp)){
            return false;
        }
        if(StringTools.isBlank(nonce)){
            return false;
        }

        try {
            return SHA1.gen(token, timestamp, nonce).equals(signature);
        } catch (Exception e) {
            return false;
        }
    }
}
