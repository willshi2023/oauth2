package com.example.web.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Aspect
//@Component
@Slf4j
public class TimeAspect {
    @Around("execution(* com.example.oauth2demo.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("TimeAspect start");
        long start = new Date().getTime();
        Object[] args = proceedingJoinPoint.getArgs();
        for(Object object:args){
            log.info("arg is: {}", JSON.toJSONString(object));
        }
        Object result = proceedingJoinPoint.proceed();
        long end = new Date().getTime();
        log.info("TimeAspect 耗时: {}",(end-start));
        log.info("TimeAspect end");
        return result;
    }
}
