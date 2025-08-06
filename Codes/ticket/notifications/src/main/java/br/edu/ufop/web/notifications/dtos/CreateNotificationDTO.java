package br.edu.ufop.web.notifications.dtos;

import java.util.UUID;

import br.edu.ufop.web.notifications.enums.EnumNotificationType;

public record CreateNotificationDTO(
    UUID userId,
    String service,
    EnumNotificationType notificationType,
    String subject,
    String content    
) {
    
}
