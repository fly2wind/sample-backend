package com.sample.domain.aggregate.order.repository;


import com.sample.domain.aggregate.order.entity.Order;
import com.sample.domain.support.repository.DomainRepository;

import java.util.Optional;

public interface OrderDomainRepository extends DomainRepository<Order, Long> {
    Optional<Order> findById(Long userId);

    Order save(Order order);
}