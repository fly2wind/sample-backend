package com.sample.domain.aggregate.order.entity;

import com.sample.domain.aggregate.order.entity.valueobject.Address;
import com.sample.domain.enums.OrderStatus;
import com.sample.domain.support.AggregateRoot;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter(AccessLevel.PROTECTED)
public class Order implements AggregateRoot<Long> {
    private Long id;

    private String customerId;

    private List<OrderItem> orderItems;

    private Address address;

    private OrderStatus status;

    public static Order create(String customerId, List<OrderItem> orderItems, Address address) {
        assert customerId != null;
        assert orderItems != null;
        return Order
                .builder()
                .customerId(customerId)
                .status(OrderStatus.CREATED)
                .orderItems(orderItems)
                .address(address)
                .build();
    }

    public BigDecimal getTotalPrice() {
        return null;
    }

    public void addOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        orderItems.add(orderItem);
    }

    public void addOrderItem(String productId, Integer quantity, BigDecimal price) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        orderItems.add(new OrderItem(productId, quantity, price));
    }
}
