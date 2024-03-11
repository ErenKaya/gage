package com.ing.gage.service.notification;

import com.ing.gage.model.dtos.notification.NotificationForInternalUserRequest;
import com.ing.gage.model.entities.notification.Notification;
import com.ing.gage.model.entities.notification.NotificationForExternalRequest;
import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.model.service.NotificationService;
import com.ing.gage.repositories.notification.NotificationRepository;
import com.ing.gage.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(UserRepository userRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void notifyUser(NotificationForInternalUserRequest request) {
        Notification notification = new Notification();
        DigitalUser user = this.userRepository.findById(request.digitalUser().getId()).orElseThrow();
        notification.setDigitalUser(user);
        notification.setTitle(request.title());
        notification.setContent(request.content());
        notification.setType(request.type());
        this.notificationRepository.save(notification);
    }

    @Override
    public void notifyUser(NotificationForExternalRequest request) {
        //intentionally blanked
    }
}
