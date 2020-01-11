package com.example.oauth2demo.web.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@RestController
@Slf4j
public class AsyncController {
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @GetMapping("/order")
    public DeferredResult<String> order() {
        log.info("主线程开始");
        String orderNumber = RandomStringUtils.randomNumeric(8);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber,result);
        mockQueue.setPlaceOrder(orderNumber);
//        Callable<String> result = new Callable<String>() {
//
//            @Override
//            public String call() throws Exception {
//                log.info("副线程开始");
//                Thread.sleep(1000);
//                log.info("副线程返回");
//                return "success";
//            }
//        };
        log.info("主线程返回");
        return result;
    }
}
