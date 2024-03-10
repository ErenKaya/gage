package com.ing.gage.repositories.notification;

import com.ing.gage.model.entities.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}