package com.spring.data.repository;

import java.util.List;

import com.spring.data.models.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepository extends JpaRepository<Message, Long>{

    @Query(value = "SELECT * FROM Message m WHERE m.conversa_id= ?1", nativeQuery = true)
	List<Message> findMessages(Long id);
}
