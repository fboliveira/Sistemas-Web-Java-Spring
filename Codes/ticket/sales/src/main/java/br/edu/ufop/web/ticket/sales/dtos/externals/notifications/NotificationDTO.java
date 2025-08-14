package br.edu.ufop.web.ticket.sales.dtos.externals.notifications;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationDTO(
    UUID id,
    UUID userId,
    String service,
    String notificationType,
    String subject,
    String content,
    LocalDateTime sentAt,
    LocalDateTime readAt
) {
}
