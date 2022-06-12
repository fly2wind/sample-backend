package com.sample.domain.support;


import java.io.Serializable;

public interface AggregateRoot<ID extends Serializable> extends Entity<ID> {

}
