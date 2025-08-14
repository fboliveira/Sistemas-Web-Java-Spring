package br.edu.ufop.web.ticket.sales.dtos.externals.notifications;

import java.util.UUID;

public record CreateNotificationDTO(
    UUID userId,
    String service,
    String notificationType,
    String subject,
    String content
) {
}
