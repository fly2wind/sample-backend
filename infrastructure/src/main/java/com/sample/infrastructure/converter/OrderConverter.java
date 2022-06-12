package com.sample.infrastructure.converter;

import com.sample.domain.aggregate.order.entity.Order;
import com.sample.domain.aggregate.order.entity.OrderItem;
import com.sample.infrastructure.persistence.dataobject.persist.OrderItemPO;
import com.sample.infrastructure.persistence.dataobject.persist.OrderPO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface OrderConverter {
    OrderConverter INSTANCE = Mappers.getMapper(OrderConverter.class);

    @Mappings({
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "province", target = "address.province"),
            @Mapping(source = "city", target = "address.city"),
            @Mapping(source = "address", target = "address.detail"),
    })
    Order toEntity(OrderPO orderPO);

    OrderItem toEntity(OrderItemPO orderItemPO);

    @InheritInverseConfiguration
    OrderPO fromEntity(Order order);

    OrderItemPO fromEntity(OrderItem orderItem);
}
