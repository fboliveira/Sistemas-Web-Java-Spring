package br.edu.ufop.web.sales.controller.dtos.events;

import br.edu.ufop.web.sales.enums.EnumEventType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDTO {

    private UUID id;

    private String description;

    private EnumEventType type;

    private LocalDateTime dateTime;

    private LocalDateTime startingSales;
    private LocalDateTime endingSales;

    private Float price;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
