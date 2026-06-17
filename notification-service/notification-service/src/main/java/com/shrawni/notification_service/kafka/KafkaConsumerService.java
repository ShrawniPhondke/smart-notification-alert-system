package com.shrawni.notification_service.kafka;

import com.shrawni.notification_service.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final EmailService emailService;

    public KafkaConsumerService(
            EmailService emailService) {

        this.emailService = emailService;
    }

    @KafkaListener(
            topics = "user-registered",
            groupId = "notification-group"
    )
    public void consume(String email) {

        System.out.println(
                "Received Message: " + email
        );

        emailService.sendWelcomeEmail(email);
    }
}