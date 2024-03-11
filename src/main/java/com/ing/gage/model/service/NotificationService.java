package com.ing.gage.model.service;

import com.ing.gage.model.dtos.notification.NotificationForInternalUserRequest;
import com.ing.gage.model.entities.notification.NotificationForExternalRequest;

public interface NotificationService {

    void notifyUser(NotificationForInternalUserRequest request);

    void notifyUser(NotificationForExternalRequest request);
}
