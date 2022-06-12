package com.sample.application.event.publish;

import com.sample.api.support.message.Message;

public interface MessageService<T extends Message> {

    void send(T msg);
}
