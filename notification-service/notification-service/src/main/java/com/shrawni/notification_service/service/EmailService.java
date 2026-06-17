package com.shrawni.notification_service.service;

//import org.springframework.mail.SimpleMailMessage;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final NotificationService notificationService;

    public EmailService(
            JavaMailSender mailSender,
            NotificationService notificationService) {

        this.mailSender = mailSender;
        this.notificationService = notificationService;
    }

    public void sendWelcomeEmail(String email) {

        try {

            MimeMessage message =
                    mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true);

            helper.setTo(email);

            helper.setSubject(
                    "Welcome to Smart Notification System"
            );

            String htmlContent = """
                    <html>
                    <body>
                        <h2>🎉 Welcome to Smart Notification System</h2>
                    
                        <p>Hello,</p>
                    
                        <p>Your account has been created successfully.</p>
                    
                        <p>
                            Thank you for joining us!
                        </p>
                    
                        <hr>
                    
                        <p>
                            <b>Smart Notification Team</b>
                        </p>
                    
                    </body>
                    </html>
                    """;

            helper.setText(
                    htmlContent,
                    true
            );

            mailSender.send(message);

            notificationService.saveNotification(
                    email,
                    "SENT"
            );

            System.out.println(
                    "Email Sent To: " + email
            );

        } catch (Exception e) {

            notificationService.saveNotification(
                    email,
                    "FAILED"
            );

            System.out.println(
                    "Email Failed: " + email
            );
        }
    }
}