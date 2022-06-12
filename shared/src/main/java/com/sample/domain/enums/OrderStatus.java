package com.sample.domain.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum OrderStatus {
    CREATED(0, "订单创建"),
    CANCELED(1, "订单取消"),
    PAID(3, "用户付款"),
    DISPATCHED(4, "订单发货"),
    FINISHED(5, "订单完成");

    private final Integer name;

    private final String message;

    OrderStatus(int name, String message) {
        this.name = name;
        this.message = message;
    }

    public static OrderStatus of(int priority) {
        return Stream.of(OrderStatus.values())
                .filter(p -> p.name == priority)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


}
