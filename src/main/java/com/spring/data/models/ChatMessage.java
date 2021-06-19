package com.spring.data.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

//@Entity
@Builder
//@Table(name ="conversa")
public class ChatMessage {
    
    @Getter
    private MessageType type;

    @Getter
    private String content;

    //@Getter No funciona
    private String sender;
    
    @Getter
    private String time;

    public String getSender() {
        return sender;
    }

}
