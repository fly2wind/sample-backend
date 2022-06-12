package com.sample.application.assembler;

import com.sample.api.dto.OrderDTO;
import com.sample.api.dto.command.OrderCreateCommand;
import com.sample.api.dto.command.OrderItemCreateCommand;
import com.sample.domain.aggregate.order.entity.Order;
import com.sample.domain.aggregate.order.entity.OrderItem;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface OrderAssembler {
    OrderAssembler INSTANCE = Mappers.getMapper(OrderAssembler.class);

    OrderDTO toDTO(Order order);

    default Order createOrder(OrderCreateCommand command) {
        List<OrderItem> items = command.getItems()
                .stream()
                .map(INSTANCE::toEntity)
                .collect(Collectors.toList());
        return Order.create(command.getCustomerId(), items, null);
    }

    OrderItem toEntity(OrderItemCreateCommand command);
}
