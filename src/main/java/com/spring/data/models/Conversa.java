package com.spring.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

//@Builder
@Entity
@Table(name = "conversa")
public class Conversa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long user_id_creador;

    private Long user_id_segon;

    private String time_started;

    public Conversa() {}
 
    public Conversa(Long user_id_creador, Long user_id_segon/*, String time_started)*/) {
		this.user_id_creador = user_id_creador;
		this.user_id_segon = user_id_segon;
		//this.time_started = time_started;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_Id_creador() {
        return user_id_creador;
    }

    public void setUser_Id_creador(Long id_creador) {
        this.user_id_creador = id_creador;
    }

    public Long getUser_Id_segon() {
        return user_id_segon;
    }

    public void setUser_Id_segon(Long id_segon) {
        this.user_id_segon = id_segon;
    }

    public String getTimeStarted() {
        return time_started;
    }

    public void setTimeStarted(String time_started) {
        this.time_started = time_started;
    }

}
