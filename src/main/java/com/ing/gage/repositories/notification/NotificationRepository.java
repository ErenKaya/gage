package com.ing.gage.repositories.notification;

import com.ing.gage.model.entities.notification.Notification;
import com.ing.gage.model.entities.user.DigitalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {


}