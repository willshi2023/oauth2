package com.example.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//@Component
@Slf4j
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("TimeInterceptor preHandle");
        log.info(((HandlerMethod)o).getBean().getClass().getName());
        log.info(((HandlerMethod)o).getMethod().getName());
        httpServletRequest.setAttribute("startTime",new Date().getTime());
        return true;
    }

    /**
     * 正常运行会被调用，抛出异常不会
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("TimeInterceptor postHandle");
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        log.info("TimeInterceptor 耗时："+(new Date().getTime()-startTime));
    }

    /**
     * 无论有没有抛出异常，都会被调用
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("TimeInterceptor afterCompletion");
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        log.info("TimeInterceptor 耗时："+(new Date().getTime()-startTime));
    }
}
