package com.sample.domain.support.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public abstract class DomainEvent {
    private final String id;

    private final LocalDateTime occurredOn;

    public DomainEvent() {
        id = UUID.randomUUID().toString();
        occurredOn = LocalDateTime.now();
    }

    /**
     * 获得事件ID
     *
     * @return 事件的ID
     */
    public String id() {
        return id;
    }

    /**
     * 获得事件发生时间
     *
     * @return 事件发生时间
     */
    public LocalDateTime occurredOn() {
        return occurredOn;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DomainEvent that = (DomainEvent) other;
        return this.id().equals(that.id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
