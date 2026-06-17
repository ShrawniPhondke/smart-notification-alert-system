package com.shrawni.notification_service.service;

import com.shrawni.notification_service.entity.Notification;
import com.shrawni.notification_service.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(
            NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void saveNotification(
            String email,
            String status
    ) {

        Notification notification =
                new Notification(
                        email,
                        status,
                        LocalDateTime.now()
                );

        notificationRepository.save(notification);
    }
    public List<Notification> getAllNotifications() {

        return notificationRepository.findAll();
    }
}