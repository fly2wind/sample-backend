package com.sample.domain.support.event;

public interface DomainEventStore {
    void store(DomainEvent event);
}
