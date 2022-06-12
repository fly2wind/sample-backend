package com.sample.application.service;

import com.sample.api.dto.OrderDTO;
import com.sample.api.dto.command.OrderCreateCommand;
import com.sample.api.dto.query.OrderQueryDTO;
import com.sample.api.support.Page;

public interface OrderService {

    OrderDTO get(Long id);

    Page<OrderDTO> findAll(OrderQueryDTO orderQueryDTO);

    OrderDTO create(OrderCreateCommand command);
}
