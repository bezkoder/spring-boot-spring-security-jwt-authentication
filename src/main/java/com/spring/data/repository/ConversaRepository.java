package com.spring.data.repository;

import java.util.List;

import com.spring.data.models.Conversa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConversaRepository extends JpaRepository<Conversa, Long>{
    @Query(value = "SELECT * FROM Conversa m WHERE m.user_Id_creador= ?1 OR m.user_Id_segon = ?1", nativeQuery = true)
	List<Conversa> findUserConverses(Long user_id_1);
}
