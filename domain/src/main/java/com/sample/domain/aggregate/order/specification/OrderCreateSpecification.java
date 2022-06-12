package com.sample.domain.aggregate.order.specification;

import com.sample.domain.aggregate.order.entity.Order;
import com.sample.domain.aggregate.order.repository.OrderDomainRepository;
import com.sample.domain.support.specification.AbstractSpecification;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderCreateSpecification extends AbstractSpecification<Order> {

    private final OrderDomainRepository orderDomainRepository;

    @Override
    public boolean isSatisfiedBy(Order order) {
        if (orderDomainRepository.findById(order.getId()).isPresent()) {
            throw new IllegalArgumentException("用户名称已存在");
        }
        return true;
    }
}
