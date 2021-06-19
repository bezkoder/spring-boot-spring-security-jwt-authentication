package com.spring.data.models;

import javax.persistence.*;

@Entity
@Table(name ="message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long conversa_id;

    private Long user_id_emisor;

    private Long user_id_receptor;

    private String message_txt;

    private String ts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getconversaId() {
        return conversa_id;
    }

    public void setconversaId(Long id) {
        this.conversa_id = id;
    }

    public Long getUseridemisor() {
        return user_id_emisor;
    }

    public void setUseridemisor(Long user_id_emisor) {
        this.user_id_emisor = user_id_emisor;
    }

    public Long getUseridreceptor() {
        return user_id_receptor;
    }

    public void setUseridreceptor(Long user_id_receptor) {
        this.user_id_receptor = user_id_receptor;
    }

    public String getmessage() {
        return message_txt;
    }

    public void setmessage(String message_txt) {
        this.message_txt = message_txt;
    }

    public String getTimestamp() {
        return ts;
    }

    public void setTimestamp(String ts) {
        this.ts = ts;
    }

    public Message() {}

    public Message(Long conversa_id, Long user_id_emisor, Long user_id_receptor, String message_txt, String ts) {
        this.conversa_id = conversa_id;
        this.user_id_emisor = user_id_emisor;
        this.user_id_receptor = user_id_receptor;
        this.message_txt = message_txt;
        this.ts = ts;
    }
}
