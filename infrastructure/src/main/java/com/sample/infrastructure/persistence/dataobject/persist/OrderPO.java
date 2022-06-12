package com.sample.infrastructure.persistence.dataobject.persist;


import com.sample.domain.aggregate.order.entity.Order;
import com.sample.domain.enums.OrderStatus;
import com.sample.infrastructure.converter.OrderConverter;
import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "t_order")
public class OrderPO implements PersistenceObject<Order> {
    private static final long serialVersionUID = -6438904677589224019L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private String customerId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "address_province")
    private String province;

    @Column(name = "address_city")
    private String city;

    @Column(name = "address_detail")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItemPO> orderItems;


    public void addOrderItem(OrderItemPO itemPO) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        itemPO.setOrder(this);
        orderItems.add(itemPO);
    }

    @Override
    public Order toEntityObject() {
        return OrderConverter.INSTANCE.toEntity(this);
    }

}
