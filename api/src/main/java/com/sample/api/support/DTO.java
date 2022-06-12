package com.sample.api.support;

import java.io.Serializable;

/**
 * Data Transfer Object, including Command, Query, Message and Response
 * <p>
 * Command and Query is CQRS concept.
 */
public abstract class DTO implements Serializable {
    private static final long serialVersionUID = 1L;
}
