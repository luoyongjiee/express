package com.sae.express.service.impl;

import com.sae.express.service.ConfigService;

/**
 * Created by luoqi on 2016-08-09.
 */
public class ConfigServiceImpl implements ConfigService {
    protected volatile String token;

    public String getToken() {
        return this.token;
    }
}
