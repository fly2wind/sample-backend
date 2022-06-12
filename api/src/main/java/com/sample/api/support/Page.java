package com.sample.api.support;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema
@JsonPropertyOrder({"pageNumber", "pageSize", "totalElements", "totalPages", "content"})
@JsonIncludeProperties({"pageNumber", "pageSize", "totalElements", "totalPages", "content"})
public class Page<T> extends DTO {
    @Schema(description = "分页页码")
    private int pageNumber;

    @Schema(description = "分页大小")
    private int pageSize;

    @Schema(description = "元素数量")
    private long totalElements;

    @Schema(description = "分页内容")
    private List<T> content;

    public Page(List<T> content, int page, int pageSize, long totalElements) {
        this.pageNumber = page;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.content = content;
    }

    public int getTotalPages() {
        return this.getPageSize() == 0 ? 1 : (int) Math.ceil((double) this.totalElements / (double) this.getPageSize());
    }

    public boolean isFirst() {
        return !this.hasPrevious();
    }

    boolean isLast() {
        return !this.hasNext();
    }

    boolean hasNext() {
        return this.getPageNumber() + 1 < this.getTotalPages();
    }

    boolean hasPrevious() {
        return this.getPageNumber() > 0;
    }
}
