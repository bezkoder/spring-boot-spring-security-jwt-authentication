package com.bezkoder.springjwt.models;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String nom;

    private String nickname;

    private String server;

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

    private String password;



    @Transient
    private String passwordConfirm;


    public User() {}
 

    public User(String nom, String username, String password) {
		this.nom = nom;
		this.username = username;
		this.password = password;
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
