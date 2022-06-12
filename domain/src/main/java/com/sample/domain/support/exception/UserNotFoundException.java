package com.sample.domain.support.exception;

public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 6792473935331601288L;

    public UserNotFoundException(Long id) {
        super("no such user {}" + id);
    }
}
