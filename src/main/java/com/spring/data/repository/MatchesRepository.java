package com.spring.data.repository;


import java.util.List;
import java.util.Optional;

import com.spring.data.models.Matches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    
    @Query(value = "SELECT * FROM Matches m WHERE m.user_id_1 = ?1 AND m.user_id_2 = ?2 OR m.user_id_1 = ?2 AND m.user_id_2 = ?1", nativeQuery = true)
    Boolean alreadyLiked(Long user_id_1, Long user_id_2);

    //Potser sense optional
    @Query(value = "SELECT * FROM Matches m WHERE m.user_id_1 = ?1 AND m.user_id_2 = ?2", nativeQuery = true)
    Optional<Matches> findByMatches(Long user_id_1, Long user_id_2);

    //OR m.user_id_1 = ?2 AND m.user_id_2 = ?1

}
    


