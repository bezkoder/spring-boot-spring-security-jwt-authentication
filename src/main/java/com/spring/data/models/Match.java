package com.spring.data.models;

import javax.persistence.*;
//import com.codesplai.spring.demo.repositories.MatchesRepository;


@Entity
@Table(name ="match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id_1")
    private Long user_id_1;

    @Column(name = "user_id_2")
    private Long user_id_2;

    private Boolean is_match;

    private Boolean is_liked = false;

    public Match() {}

    public Match(Long user_id_1, Long user_id_2) {
        this.user_id_1 = user_id_1;
        this.user_id_2 = user_id_2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_Id_1() {
        return user_id_1;
    }

    public void setUser_Id_1(Long id_user) {
        this.user_id_1 = id_user;
    }

    public Long getUser_Id_2() {
        return user_id_2;
    }

    public void setUser_Id_2(Long id_user) {
        this.user_id_2 = id_user;
    }

    public Boolean getIs_Match() {
        return is_match;
    }

    public Boolean setIs_Match(Boolean is_match) {
        return this.is_match = is_match;
    }

    public Boolean getIs_Liked() {
        return is_liked;
    }

    public Boolean setIs_Liked(Boolean is_liked) {
        return this.is_liked = is_liked;
    }

    @Override
    public String toString() {
        return "Match{" + "id=" + id + ", name2=" + user_id_1 + ", name=" + user_id_2 + /*",is match=" + is_match +*/'}';
    }


}
