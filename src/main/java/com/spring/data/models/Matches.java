package com.spring.data.models;

import javax.persistence.*;
//import com.codesplai.spring.demo.repositories.MatchesRepository;


@Entity
@Table(name ="matches")
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "user_id_1")
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "user_id_1", referencedColumnName = "id")
    private Long user_id_1;

   //@OneToOne(cascade = CascadeType.ALL)
   //@JoinColumn(name = "user_id_2", referencedColumnName = "id")
    private Long user_id_2;

    @Column(name = "is_match", columnDefinition = "boolean default false")
    private Boolean is_match = false;

    //@Column(name = "liked_1", columnDefinition = "boolean default true")
    private Boolean liked_1;

    @Column(name = "liked_2", columnDefinition = "boolean default false")
    private Boolean liked_2 = false;

    public Matches() {}

    /*public Matches(Long user_id_1, Long user_id_2) {
        this.user_id_1 = user_id_1;
        this.user_id_2 = user_id_2;
    }*/

    public Matches(long user_id_1, long user_id_2, Boolean liked_1, boolean liked_2, boolean is_match) {
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

    public Boolean getLiked_1() {
        return liked_1;
    }

    public Boolean setIs_Liked_1(Boolean liked_1) {
        return this.liked_1 = liked_1;
    }

    public Boolean getLiked_2() {
        return liked_2;
    }

    public Boolean setLiked_2(Boolean liked_2) {
        return this.liked_2 = liked_2;
    }

    @Override
    public String toString() {
        return "Match{" + "id=" + id + ", name2=" + user_id_1 + ", name=" + user_id_2 + /*",is match=" + is_match +*/'}';
    }


}
