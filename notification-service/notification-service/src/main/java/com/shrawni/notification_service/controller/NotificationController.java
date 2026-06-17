package com.shrawni.notification_service.controller;

import com.shrawni.notification_service.entity.Notification;
import com.shrawni.notification_service.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService) {

        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public List<Notification> getNotifications() {

        return notificationService.getAllNotifications();
    }
}