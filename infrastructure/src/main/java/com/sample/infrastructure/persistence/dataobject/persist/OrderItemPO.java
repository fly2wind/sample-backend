package com.sample.infrastructure.persistence.dataobject.persist;

import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_order_items")
public class OrderItemPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderPO order;

    private Long productId;

    private Integer quantity;

    private BigDecimal price;

    @Transient
    private BigDecimal totalPrice;
}
