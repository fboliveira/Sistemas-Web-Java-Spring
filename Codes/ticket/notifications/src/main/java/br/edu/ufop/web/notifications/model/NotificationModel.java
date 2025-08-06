package br.edu.ufop.web.notifications.model;

import java.time.LocalDateTime;
import java.util.UUID;

import br.edu.ufop.web.notifications.enums.EnumNotificationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_notifications")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private UUID userId; // UserModel ?
    
    @Column(nullable = false, length = 100)
    private String service;
    
    @Column(nullable = false)
    private EnumNotificationType notificationType;
    
    @Column(nullable = false)
    private String subject;
    
    @Column(nullable = false, columnDefinition = "text")
    private String content;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    
    private LocalDateTime sentAt;
    private LocalDateTime readAt;

    @PrePersist
    public void antesDeGravar() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void antesDeAtualizar() {
        this.updatedAt = LocalDateTime.now();
    }

}
