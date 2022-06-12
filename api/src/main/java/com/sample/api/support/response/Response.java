package com.sample.api.support.response;

import com.sample.api.support.DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Schema
public class Response<T> extends DTO {
    @Schema(description = "响应状态")
    private Status status;

    @Schema(description = "响应编码")
    private Integer code;

    @Schema(description = "响应信息")
    private String message;

    @Schema(description = "响应对象")
    private T data;

    public static <T> Response<T> ok() {
        return Response.<T>builder().status(Status.SUCCESS).build();
    }

    public static <T> Response<T> ok(T data) {
        return Response.<T>builder().status(Status.SUCCESS).data(data).build();
    }

    public enum Status {
        SUCCESS, FAILED
    }
}

