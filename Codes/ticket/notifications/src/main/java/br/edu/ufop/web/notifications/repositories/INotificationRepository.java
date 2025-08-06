package br.edu.ufop.web.notifications.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufop.web.notifications.model.NotificationModel;

public interface INotificationRepository extends JpaRepository<NotificationModel, UUID> {

    List<NotificationModel> findAllByUserId(UUID userId);
    List<NotificationModel> findAllByUserIdIn(List<UUID> userIdList);
    
}
