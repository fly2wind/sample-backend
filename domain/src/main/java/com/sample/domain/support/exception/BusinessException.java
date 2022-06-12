package com.sample.domain.support.exception;

public class BusinessException extends RuntimeException {
    private final Integer code;
    private final String message;

    public BusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(Integer code, String message, Throwable throwable) {
        super(throwable);
        this.code = code;
        this.message = message;
    }
}
