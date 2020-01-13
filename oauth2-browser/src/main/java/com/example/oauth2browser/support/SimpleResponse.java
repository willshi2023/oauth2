package com.example.oauth2browser.support;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
public class SimpleResponse {
    private Object content;
    public SimpleResponse(Object content){
        this.content = content;
    }
}
