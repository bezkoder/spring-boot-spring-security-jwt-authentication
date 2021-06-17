package com.spring.data.repository;


import java.util.List;
import java.util.Optional;

import com.spring.data.models.Matches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchesRepository extends JpaRepository<Matches, Long> {
    
    @Query(value = "SELECT * FROM Matches m WHERE m.user_id_1 = ?1 AND m.user_id_2 = ?2", nativeQuery = true)
	Boolean findIsMatch(Long user_id_1, Long user_id_2);

    //S'ha de posar que nomes surtin el id_user
    // SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2"
    @Query(value = "SELECT * FROM Matches m WHERE m.is_match = 1 AND m.user_id_1 = ?1 OR m.user_id_2 = ?1", nativeQuery = true)
	List<Matches> findUserMatches(Long user_id_1);

    @Query(value = "SELECT * FROM Matches m WHERE m.user_id_1 = ?1 OR m.user_id_2 = ?1 AND m.is_match = 0", nativeQuery = true)
	List<Matches> findUserNotMatches(Long user_id_1);
    
    @Query(value = "SELECT count(*) FROM Matches m WHERE m.user_id_1 = ?1 AND m.user_id_2 = ?2 OR m.user_id_1 = ?2 AND m.user_id_2 = ?1 AND m.liked_1 = 1", nativeQuery = true)
    int alreadyLiked(Long user_id_1, Long user_id_2);

    @Query(value = "SELECT * FROM Matches m WHERE m.liked_1 = 1 AND m.user_id_1 = ?1 AND m.user_id_2 = ?2", nativeQuery = true)
    Boolean user1_liked(Long user_id_1, Long user_id_2);

    //Potser sense optional
    @Query(value = "SELECT * FROM Matches m WHERE m.user_id_1 = ?1 AND m.user_id_2 = ?2", nativeQuery = true)
    Optional<Matches> findByMatches(Long user_id_1, Long user_id_2);

    @Query(value = "SELECT * FROM Matches m WHERE m.user_id_1 = ?1 AND m.user_id_2 = ?2 OR m.user_id_1 = ?2 AND m.user_id_2 = ?1", nativeQuery = true)
    Long findIdByUsers(Long user_id_1, Long user_id_2);
    
    @Query(value = "SELECT * FROM Matches m WHERE m.user_id_1 = ?1 AND m.user_id_2 = ?2 OR m.user_id_1 = ?2 AND m.user_id_2 = ?1", nativeQuery = true)
    Optional<Matches> findTableByUsers(Long user_id_1, Long user_id_2);

    void save(Optional<Matches> matchData);

    /*@Modifying
    @Query(value = "INSERT INTO MATCHES (user_id_1, user_id_2, is_match, liked_1, liked_2) values (:user_id_1, :user_id_2, :is_match, :status)", nativeQuery = true)
    void insertUser(@Param("user_id_1") Long user_id_1, @Param("user_id_2") Long user_id_2, @Param("is_match") Integer status, @Param("email") String email);*/

}
    



/*
getReportes 
*/