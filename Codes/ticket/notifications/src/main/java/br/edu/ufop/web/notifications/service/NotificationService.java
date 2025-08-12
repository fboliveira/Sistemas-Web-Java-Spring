package br.edu.ufop.web.notifications.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.notifications.converter.NotificationConverter;
import br.edu.ufop.web.notifications.domain.NotificationDomain;
import br.edu.ufop.web.notifications.dtos.CreateNotificationDTO;
import br.edu.ufop.web.notifications.dtos.NotificationDTO;
import br.edu.ufop.web.notifications.model.NotificationModel;
import br.edu.ufop.web.notifications.repositories.INotificationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService {
    
    private final INotificationRepository notificationRepository;

    public List<NotificationDTO> getAll() {
        return notificationRepository.findAll()
                .stream().map(NotificationConverter::toNotificationDTO)
                .toList();
    }

    public NotificationDTO create(CreateNotificationDTO createNotificationDTO) {

        NotificationDomain notificationDomain = NotificationConverter.toNotificationDomain(createNotificationDTO);

        // Use cases ...

        // Converter para entidade JPA
        NotificationModel notificationModel = NotificationConverter.toNotificationModel(notificationDomain);

        // Persistência e retorno - DTO de saída
        return NotificationConverter.toNotificationDTO(
            notificationRepository.save(notificationModel)
        );

    }

}
