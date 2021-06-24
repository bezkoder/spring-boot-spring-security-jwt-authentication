package com.spring.data.repository;

import java.util.Optional;

import com.spring.data.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByNom(String username);

	Boolean existsByUsername(String username);

	@Query(value = "SELECT * FROM User u WHERE u.id = ?1 AND u.modo_duo = ?2", nativeQuery = true)
	User findUserByIdAndModo(Long id, Boolean modo_duo);
}
