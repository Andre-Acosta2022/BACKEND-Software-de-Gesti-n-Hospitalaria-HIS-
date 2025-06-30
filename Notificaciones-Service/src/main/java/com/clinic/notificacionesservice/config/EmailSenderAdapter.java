package com.clinic.notificacionesservice.config;
import com.clinic.notificacionesservice.domain.model.Notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class EmailSenderAdapter {

    private final JavaMailSender mailSender;

    public void send(Notification notification) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(" andre.acosta.2024.official@gmail.com"); // Puedes hacerlo configurable si quieres
            message.setTo(notification.getRecipient());
            message.setSubject(notification.getSubject());
            message.setText(notification.getMessage());

            mailSender.send(message);
            log.info("✅ Email enviado a {}", notification.getRecipient());

        } catch (Exception e) {
            log.error("❌ Error al enviar email: {}", e.getMessage());
            throw new RuntimeException("Error al enviar email", e);
        }
    }
}