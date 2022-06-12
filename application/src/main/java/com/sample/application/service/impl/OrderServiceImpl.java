package com.sample.application.service.impl;

import com.sample.api.dto.OrderDTO;
import com.sample.api.dto.command.OrderCreateCommand;
import com.sample.api.dto.query.OrderQueryDTO;
import com.sample.api.support.Page;
import com.sample.application.assembler.OrderAssembler;
import com.sample.application.event.publish.MessageService;
import com.sample.application.repository.OrderQueryRepository;
import com.sample.application.service.OrderService;
import com.sample.domain.aggregate.order.entity.Order;
import com.sample.domain.aggregate.order.event.OrderCreatedEvent;
import com.sample.domain.aggregate.order.repository.OrderDomainRepository;
import com.sample.domain.support.event.DomainEventBus;
import com.sample.domain.support.event.DomainEventSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDomainRepository orderDomainRepository;

    private final OrderQueryRepository orderQueryRepository;

    private final MessageService messageService;

    @Transactional(readOnly = true)
    public OrderDTO get(Long id) {
        return orderDomainRepository.findById(id).map(OrderAssembler.INSTANCE::toDTO).orElseThrow();
    }

    @Override
    public Page<OrderDTO> findAll(OrderQueryDTO orderQueryDTO) {
        return orderQueryRepository.findAll(orderQueryDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO create(OrderCreateCommand command) {
        Order order = OrderAssembler.INSTANCE.createOrder(command);

        order = orderDomainRepository.save(order);

        DomainEventBus.INSTANCE.register(new DomainEventSubscriber<OrderCreatedEvent>() {
            public void handleEvent(OrderCreatedEvent domainEvent) {
                System.out.println("@#@#$@#!@#!#!" + domainEvent.id());
            }
        });
        DomainEventBus.INSTANCE.post(new OrderCreatedEvent());

        return OrderAssembler.INSTANCE.toDTO(order);
    }
}
