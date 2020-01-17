package com.example.oauth2core.validate.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class ValidateCodeProcessorHolder {
    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + "CodeProcessor";
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            log.error("验证码处理器" + name + "不存在");
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }
}
