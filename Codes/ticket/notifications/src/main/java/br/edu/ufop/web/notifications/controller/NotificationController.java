package br.edu.ufop.web.notifications.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufop.web.notifications.dtos.CreateNotificationDTO;
import br.edu.ufop.web.notifications.dtos.NotificationDTO;
import br.edu.ufop.web.notifications.service.NotificationService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
public class NotificationController {
 
    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<NotificationDTO>> getAll() {
        return ResponseEntity.ok(
            notificationService.getAll()
        );
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Notification service is running.");
    }

    @PostMapping
    public ResponseEntity<NotificationDTO> create(
        @RequestBody CreateNotificationDTO createNotificationDTO) {

        NotificationDTO notificationDTO = notificationService.create(createNotificationDTO);

        return ResponseEntity.ok(notificationDTO);

    }
    
}
