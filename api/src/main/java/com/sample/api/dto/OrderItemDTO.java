package com.sample.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Schema
public class OrderItemDTO {
    @Schema(description = "产品编码")
    private String productId;

    @Schema(description = "产品数量")
    private int quantity;

    @Schema(description = "产品单价")
    private BigDecimal price;
}
