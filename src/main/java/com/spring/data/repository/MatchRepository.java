package com.spring.data.repository;

import com.spring.data.models.Match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    
    /*@Query(value = "SELECT * FROM Match m WHERE m.user_id_1 = ?1 AND m.user_id_2 = ?2", nativeQuery = true)
	Match findIsMatch(Long user_id_1, Long user_id_2);

    @Query(value = "SELECT * FROM Match m WHERE m.user_id_1 = ?1 OR m.user_id_2 = ?1", nativeQuery = true)
	Match findUserMatches(Long user_id_1);*/

}
    


