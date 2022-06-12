package com.sample.api.dto.command;

import com.sample.api.support.command.Command;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Schema
public class OrderCreateCommand extends Command {
    @Schema(description = "客户ID")
    @NotBlank(message = "客户ID不能为空")
    private String customerId;

    @Schema(description = "订单项")
    @NotEmpty(message = "订单项不能为空")
    private List<OrderItemCreateCommand> items;
}
