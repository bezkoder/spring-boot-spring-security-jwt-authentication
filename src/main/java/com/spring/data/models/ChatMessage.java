package com.spring.data.models;

import javax.persistence.Column;
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


    @Column(name = "user_id_emisor")
    //@Getter No funciona
    private String sender;
    
    @Column(name = "ts")
    @Getter
    private String time;

    @Column(name = "conversa_id")
    private Long conversa_id;

    public String getSender() {
        return sender;
    }

    public Long getConversaId() {
        return conversa_id;
    }

    public void setConversaId(Long conversa_id) {
        this.conversa_id = conversa_id;
    }


}
