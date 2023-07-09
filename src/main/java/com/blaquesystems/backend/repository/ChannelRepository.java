package com.blaquesystems.backend.repository;

import com.blaquesystems.backend.models.Channel;
import com.blaquesystems.backend.models.EChannel;
import com.blaquesystems.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
    Optional<Channel> findByName(EChannel name);
    Boolean existsByName(EChannel name);
}
