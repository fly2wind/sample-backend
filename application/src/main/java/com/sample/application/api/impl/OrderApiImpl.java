package com.sample.application.api.impl;

import com.sample.api.OrderApi;
import com.sample.api.dto.OrderDTO;
import com.sample.api.dto.command.OrderCreateCommand;
import com.sample.api.dto.query.OrderQueryDTO;
import com.sample.api.support.Page;
import com.sample.api.support.response.Response;
import com.sample.application.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/orders")
public class OrderApiImpl implements OrderApi {

    private final OrderService orderService;

    public OrderApiImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    @GetMapping("/{code}")
    public Response<OrderDTO> get(@PathVariable Long code) {
        OrderDTO orderDTO = orderService.get(code);
        orderDTO.setCreateTime(LocalDateTime.now());
        return Response.ok(orderDTO);
    }

    @Override
    @GetMapping
    public Response<Page<OrderDTO>> list(OrderQueryDTO orderQueryDTO) {
        Page<OrderDTO> users = orderService.findAll(orderQueryDTO);
        return Response.ok(users);
    }

    @Override
    @PostMapping
    public Response<OrderDTO> create(@RequestBody OrderCreateCommand command) {
        OrderDTO orderDTO = orderService.create(command);
        return Response.ok(orderDTO);
    }
}
