package com.blaquesystems.backend.repository;

import com.blaquesystems.backend.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
