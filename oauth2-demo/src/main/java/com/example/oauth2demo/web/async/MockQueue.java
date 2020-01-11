package com.example.oauth2demo.web.async;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Getter
@Slf4j
public class MockQueue {
    private String placeOrder;
    private String completeOrder;

    public void setPlaceOrder(String placeOrder)  {
        new Thread(()->{
            log.info("接到下单请求: {}",placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("error is: {}",e.getMessage());
            }
            this.completeOrder = placeOrder;
            log.info("下单请求处理完毕: {}",placeOrder);
        }).start();
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
