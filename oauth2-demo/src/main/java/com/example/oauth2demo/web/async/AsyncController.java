package com.example.oauth2demo.web.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@Slf4j
public class AsyncController {
    @GetMapping("/order")
    public Callable<String> order() throws InterruptedException {
        log.info("主线程开始");
        Callable<String> result = new Callable<String>() {

            @Override
            public String call() throws Exception {
                log.info("副线程开始");
                Thread.sleep(1000);
                log.info("副线程返回");
                return "success";
            }
        };
        log.info("主线程返回");
        return result;
    }
}
