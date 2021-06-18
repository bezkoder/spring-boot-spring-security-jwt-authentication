package com.spring.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reportes")
public class Reportes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long user_id;
    
    private Long user_id_reported;

    private String motiu;

    private String comentari;

    private String prova;

    private Boolean solucionado = false;

    public Reportes() {}

    public Reportes(Long user_id, Long user_id_reported, String motiu, String comentari, String prova, Boolean solucionado) {
		this.user_id = user_id;
		this.user_id_reported = user_id_reported;
		this.motiu = motiu;
        this.comentari = comentari;
        this.prova = prova;
        this.solucionado = solucionado;
	}

    public Long getUserId() {
        return user_id;
    } 

    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }

    public Long getUserId_reported() {
        return user_id_reported;
    } 

    public void setUserId_reported(Long user_id_reported) {
        this.user_id_reported = user_id_reported;
    }

    public String getMotiu() {
        return motiu;
    } 

    public void setMotiu(String motiu) {
        this.motiu = motiu;
    }

    public String getComentari() {
        return comentari;
    } 

    public void setComentari(String comentari) {
        this.comentari = comentari;
    }

    public String getProva() {
        return prova;
    } 

    public void setProva(String prova) {
        this.prova = prova;
    }

    public Boolean getSolucionado() {
        return solucionado;
    } 

    public void setSolucionado(Boolean solucionado) {
        this.solucionado = solucionado;
    }

    @Override
    public String toString() {
        return "Reporte{" + "id=" + id + ", usuari=" + user_id + ", usuari_reportat=" + user_id_reported + ", motiu=" + motiu + ", comentari=" + comentari + '}';
    }
}



