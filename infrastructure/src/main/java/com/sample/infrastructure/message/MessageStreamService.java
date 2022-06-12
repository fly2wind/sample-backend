package com.sample.infrastructure.message;

import com.sample.api.support.message.Message;
import com.sample.application.event.publish.MessageService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class MessageStreamService<T extends Message> implements MessageService<T> {
    private final StreamBridge streamBridge;

    public MessageStreamService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public void send(T msg) {
        System.out.println("发送消息" + msg);
        streamBridge.send("sample-out-0", msg);
    }
}
