package com.sample.domain.support.service;

import com.sample.domain.aggregate.order.entity.Order;
import com.sample.domain.aggregate.order.repository.OrderDomainRepository;
import com.sample.domain.support.exception.UserNotFoundException;
import lombok.SneakyThrows;

public class DomainService {

    private final OrderDomainRepository orderDomainRepository;

    public DomainService(OrderDomainRepository orderDomainRepository) {
        this.orderDomainRepository = orderDomainRepository;
    }

    @SneakyThrows
    public Order get(Long id) {
        return orderDomainRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
