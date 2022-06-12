package com.sample.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Schema
public class OrderDTO {

    @Schema(description = "用户编码")
    private Long id;

    @Schema(description = "用户名称")
    private String username;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "订单项")
    private List<OrderItemDTO> orderItems;
}
