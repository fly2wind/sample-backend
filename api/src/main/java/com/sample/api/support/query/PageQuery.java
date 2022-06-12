package com.sample.api.support.query;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Schema
public class PageQuery extends Query {
    @Schema(description = "分页页码", defaultValue = "1", minimum = "1")
    private final int pageNumber;

    @Schema(description = "分页大小", defaultValue = "10", minimum = "10", maximum = "100")
    private final int pageSize;

    @Schema(description = "排序字段", nullable = true)
    private String orderBy;

    @Schema(description = "排序方向", nullable = true, allowableValues = {"ASC", "DESC"})
    private String orderDirection;

    public PageQuery() {
        this(1, 10);
    }

    public PageQuery(int page, int size) {
        if (page < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        } else if (size < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        } else {
            this.pageNumber = page;
            this.pageSize = size;
        }
    }

    @Hidden
    public long getOffset() {
        return (long) this.pageNumber * (long) this.pageSize;
    }

    @Hidden
    public boolean hasPrevious() {
        return this.pageNumber > 0;
    }
}
