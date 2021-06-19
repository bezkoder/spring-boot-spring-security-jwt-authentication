package com.spring.data.repository;

import com.spring.data.models.Conversa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversaRepository extends JpaRepository<Conversa, Long>{
    
}
