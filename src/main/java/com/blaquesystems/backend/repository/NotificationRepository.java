package com.blaquesystems.backend.repository;

import com.blaquesystems.backend.models.Channel;
import com.blaquesystems.backend.models.Notification;
import com.blaquesystems.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    void deleteByChannel(Channel channel);
    void deleteByUser(User user);
}
