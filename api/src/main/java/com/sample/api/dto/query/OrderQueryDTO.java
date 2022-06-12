package com.sample.api.dto.query;

import com.sample.api.support.query.PageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema
public class OrderQueryDTO extends PageQuery {
    @Schema(description = "根据用户名查询", nullable = true)
    private String username;
}
