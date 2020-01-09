package com.example.oauth2demo.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

@Slf4j
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("TimeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("TimeFilter start");
        long start = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        long end = new Date().getTime();
        log.info("TimeFilter 耗时: {}",(end-start));
        log.info("TimeFilter finish");
    }

    @Override
    public void destroy() {
        log.info("TimeFilter destroy");
    }
}
