package com.sample.application.event.subscribe;

import com.sample.application.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component("sample")
public class OrderMessageConsumer implements Consumer<String> {

    private final OrderService orderService;

    public OrderMessageConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void accept(String s) {
        System.out.println("21321312312312313" + s) ;
        System.out.println("21321312312312313");
        orderService.get(1L);
    }
}
