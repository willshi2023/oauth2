package com.example.oauth2core.validate.core.impl;

import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;

public abstract class AbstractValidateCodeProcessor {
    /**
     * 操作session的工具集
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
}
