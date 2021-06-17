package com.spring.data.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;
    
    @Column(name = "nom")
    private String nom;

    private String nickname;

    private String server;

    private String rol_pred;

    private String img;

    private String details;

    //Modos ---> Fer una taula que tingui id i el modo (1-4) que vol jugar
    private Boolean modo_flex;

    private Boolean modo_duo;

    private Boolean modo_clash;

    private Boolean modo_otro;

    //Tipos ---> Fer una taula que tingui id i el modo (1-5) que vol jugar
    private Boolean tipo_4fun;
    
    private Boolean tipo_tryhard;

    private Boolean tipo_champs;

    private Boolean tipo_otps;

    private Boolean rol_jungle;

    //Rols ---> Fer una taula que tingui id i el modo (1-5) que vol jugar
    private Boolean rol_top;

    private Boolean rol_mid;

    private Boolean rol_bot;

    private Boolean rol_supp;

    private Boolean rol_fill;

   // Suposo que faltaria una pels personatges

   @Column(name = "password")
    private String password;



    @Transient
    private String passwordConfirm;


    public User() {}
 

    public User(String nom, String username, String password) {
		this.nom = nom;
		this.username = username;
		this.password = password;
	}

    public User(Boolean modo_flex, Boolean modo_duo, Boolean modo_clash, Boolean modo_otro) {
        this.modo_flex = modo_flex;
        this.modo_duo = modo_duo;
        this.modo_clash = modo_clash;
        this.modo_otro = modo_otro;
    }

    @ManyToMany
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getRolPred() {
        return rol_pred;
    }
    
    public void setRolPred(String rol_pred) {
        this.rol_pred = rol_pred;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



    //  --->     MODOS
    public Boolean getFlex() {
        return modo_flex;
    }

    public void setFlex(Boolean modo_flex) {
        this.modo_flex = modo_flex;
    }

    public Boolean getClash() {
        return modo_clash;
    }

    public void setClash(Boolean modo_clash) {
        this.modo_clash = modo_clash;
    }

    public Boolean getDuo() {
        return modo_duo;
    }

    public void setDuo(Boolean modo_duo) {
        this.modo_duo = modo_duo;
    }

    public Boolean getOtro() {
        return modo_otro;
    }

    public void setOtro(Boolean modo_otro) {
        this.modo_otro = modo_otro;
    }

    //  --->    TIPOS
    public Boolean get4fun() {
        return tipo_4fun;
    }
    
    public void set4fun(Boolean tipo_4fun) {
        this.tipo_4fun = tipo_4fun;
    }

    public Boolean getChamps() {
        return tipo_champs;
    }
    
    public void setChamps(Boolean tipo_champs) {
        this.tipo_champs = tipo_champs;
    }

    public Boolean getOtps() {
        return tipo_otps;
    }
    
    public void setOtps(Boolean tipo_otps) {
        this.tipo_otps = tipo_otps;
    }

    public Boolean getTryHard() {
        return tipo_tryhard;
    }
    
    public void setTryHard(Boolean tipo_tryhard) {
        this.tipo_tryhard = tipo_tryhard;
    }

    //  --->    ROLS

    public Boolean getBot() {
        return rol_bot;
    }
    
    public void setBot(Boolean rol_bot) {
        this.rol_bot = rol_bot;
    }

    public Boolean getFill() {
        return rol_fill;
    }
    
    public void setFill(Boolean rol_fill) {
        this.rol_fill = rol_fill;
    }
        
    public Boolean getJungle() {
        return rol_jungle;
    }
    
    public void setJungle(Boolean rol_jungle) {
        this.rol_jungle = rol_jungle;
    }

    public Boolean getMid() {
        return rol_mid;
    }
    
    public void setMid(Boolean rol_mid) {
        this.rol_mid = rol_mid;
    }

    public Boolean getSupp() {
        return rol_supp;
    }
    
    public void setSupp(Boolean rol_supp) {
        this.rol_supp = rol_supp;
    }

    public Boolean getTop() {
        return rol_top;
    }
    
    public void setTop(Boolean rol_top) {
        this.rol_top = rol_top;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + nom + ", email=" + username + ", server=" + server + ", nickname=" + nickname + '}';
    }
}
