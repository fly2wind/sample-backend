package com.sample.application.repository;

import com.sample.api.dto.OrderDTO;
import com.sample.api.dto.query.OrderQueryDTO;
import com.sample.api.support.Page;

public interface OrderQueryRepository {
    Page<OrderDTO> findAll(OrderQueryDTO orderQueryDTO);
}
