package br.edu.ufop.web.notifications.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.edu.ufop.web.notifications.enums.EnumNotificationType;

public record NotificationDTO(

    UUID id,
    UUID userId,
    String service,
    EnumNotificationType notificationType,
    String subject,
    String content,
    LocalDateTime sentAt,
    LocalDateTime readAt

) {
    
}
