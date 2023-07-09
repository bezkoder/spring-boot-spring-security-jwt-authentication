package com.blaquesystems.backend.repository;

import com.blaquesystems.backend.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByName(String name);

    Boolean existsByContact(String contact);


}
