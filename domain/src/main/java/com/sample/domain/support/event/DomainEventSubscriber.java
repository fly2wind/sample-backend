package com.sample.domain.support.event;

import com.google.common.eventbus.Subscribe;

/**
 * 处理领域事件的Subscriber
 *
 * @param <T>
 */
public interface DomainEventSubscriber<T extends DomainEvent> {
    /**
     * 处理领域事件
     */
    @Subscribe
    void handleEvent(final T event);
}
