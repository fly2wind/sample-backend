package com.sample.domain.support.event;

import com.google.common.eventbus.EventBus;

public class DomainEventBus {
    public final static DomainEventBus INSTANCE = new DomainEventBus();

    private final EventBus eventBus;

    private DomainEventBus() {
        eventBus = new EventBus();
    }

    /**
     * 注册事件处理器
     *
     * @param subscriber 要注册的事件处理器
     */
    public void register(DomainEventSubscriber subscriber) {
        eventBus.register(subscriber);
    }

    /**
     * 注销事件处理器
     *
     * @param subscriber 要注销的事件处理器
     */
    public void unregister(DomainEventSubscriber subscriber) {
        eventBus.unregister(subscriber);
    }

    /**
     * 发布领域事件
     *
     * @param event 要发布的领域事件
     */
    public void post(DomainEvent event) {
        eventBus.post(event);
    }
}
