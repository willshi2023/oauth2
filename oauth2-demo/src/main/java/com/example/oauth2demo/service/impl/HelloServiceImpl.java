package com.example.oauth2demo.service.impl;

import com.example.oauth2demo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        log.info("greeting");
        return "hello "+name;
    }
}
