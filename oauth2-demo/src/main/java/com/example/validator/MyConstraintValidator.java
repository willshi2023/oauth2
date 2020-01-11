package com.example.validator;

import com.alibaba.fastjson.JSON;
import com.example.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 不需要加component注解，只要是实现了ConstraintValidator接口，就会被spring管理，可以直接 Autowired
 */
@Slf4j
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {
    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        log.info("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.greeting("tom");
        log.info(JSON.toJSONString(value));
        return false;
    }
}
