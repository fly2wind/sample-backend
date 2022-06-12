package com.sample.infrastructure.persistence.repository;

import com.sample.domain.aggregate.order.entity.Order;
import com.sample.domain.aggregate.order.repository.OrderDomainRepository;
import com.sample.infrastructure.converter.OrderConverter;
import com.sample.infrastructure.persistence.dataobject.persist.OrderPO;
import com.sample.infrastructure.persistence.jpa.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderDomainRepositoryImpl implements OrderDomainRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Optional<Order> findById(Long userId) {
        return orderJpaRepository.findById(userId).map(OrderPO::toEntityObject);
    }

    @Override
    public Order save(Order order) {
        OrderPO orderPO = OrderConverter.INSTANCE.fromEntity(order);
        orderJpaRepository.save(orderPO);

        System.out.println(orderPO.getId());
        System.out.println(orderPO.getStatus());

        return OrderConverter.INSTANCE.toEntity(orderPO);
    }
}
