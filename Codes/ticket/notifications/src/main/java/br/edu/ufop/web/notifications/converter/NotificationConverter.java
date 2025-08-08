package br.edu.ufop.web.notifications.converter;

import br.edu.ufop.web.notifications.domain.NotificationDomain;
import br.edu.ufop.web.notifications.dtos.CreateNotificationDTO;
import br.edu.ufop.web.notifications.dtos.NotificationDTO;
import br.edu.ufop.web.notifications.model.NotificationModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NotificationConverter {

    public static NotificationDomain toNotificationDomain(CreateNotificationDTO createNotificationDTO) {

        return NotificationDomain.builder()
                .userId(createNotificationDTO.userId())
                .service(createNotificationDTO.service())
                .notificationType(createNotificationDTO.notificationType())
                .subject(createNotificationDTO.subject())
                .content(createNotificationDTO.content())
                .build();

    }

    public static NotificationModel toNotificationModel(NotificationDomain notificationDomain) {

        return NotificationModel.builder()
                .id(notificationDomain.getId())
                .userId(notificationDomain.getUserId())
                .service(notificationDomain.getService())
                .notificationType(notificationDomain.getNotificationType())
                .subject(notificationDomain.getSubject())
                .content(notificationDomain.getContent())
                .sentAt(notificationDomain.getSentAt())
                .readAt(notificationDomain.getReadAt())
                .build();

    }

    public static NotificationDTO toNotificationDTO(NotificationModel notificationModel) {

        return new NotificationDTO(
                notificationModel.getId(),
                notificationModel.getUserId(),
                notificationModel.getService(),
                notificationModel.getNotificationType(),
                notificationModel.getSubject(),
                notificationModel.getContent(),
                notificationModel.getSentAt(),
                notificationModel.getReadAt());
    }

}
