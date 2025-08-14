package br.edu.ufop.web.ticket.sales.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ufop.web.ticket.sales.dtos.externals.notifications.CreateNotificationDTO;
import br.edu.ufop.web.ticket.sales.dtos.externals.notifications.NotificationDTO;

@FeignClient("notifications-service")
public interface NotificationServiceClient {
    
    @PostMapping("/notifications")
    public NotificationDTO create(@RequestBody CreateNotificationDTO createNotificationDTO);

} 
