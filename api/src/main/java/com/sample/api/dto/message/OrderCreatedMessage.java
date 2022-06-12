package com.sample.api.dto.message;

import com.sample.api.support.message.Message;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreatedMessage extends Message {
    private String text;

    public OrderCreatedMessage() {
        text = "asdasds";
    }
}
