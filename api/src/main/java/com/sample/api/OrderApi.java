package com.sample.api;

import com.sample.api.dto.OrderDTO;
import com.sample.api.dto.command.OrderCreateCommand;
import com.sample.api.dto.query.OrderQueryDTO;
import com.sample.api.support.Page;
import com.sample.api.support.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "OrderApi", description = "订单接口")
public interface OrderApi {

    @Operation(summary = "获取订单信息")
    Response<OrderDTO> get(@Parameter(in = ParameterIn.PATH, description = "订单编码") Long code);

    @Operation(summary = "获取订单信息列表")
    Response<Page<OrderDTO>> list(@Parameter(in = ParameterIn.QUERY) OrderQueryDTO orderQueryDTO);

    @Operation(summary = "获取订单信息列表", description = "需要具备管理员权限")
    Response<OrderDTO> create(@Parameter OrderCreateCommand command);
}
