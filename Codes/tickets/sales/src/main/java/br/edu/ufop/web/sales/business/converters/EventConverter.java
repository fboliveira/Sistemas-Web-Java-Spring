package br.edu.ufop.web.sales.business.converters;

import br.edu.ufop.web.sales.controller.dtos.events.CreateEventDTO;
import br.edu.ufop.web.sales.controller.dtos.events.EventDTO;
import br.edu.ufop.web.sales.enums.EnumEventType;
import br.edu.ufop.web.sales.infrastructure.entities.EventEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventConverter {

    public static EventDTO toDTO(EventEntity eventEntity) {

        return EventDTO.builder()
                .id(eventEntity.getId())
                .description(eventEntity.getDescription())
                .type(eventEntity.getType())
                .dateTime(eventEntity.getDateTime())
                .startingSales(eventEntity.getStartingSales())
                .endingSales(eventEntity.getEndingSales())
                .price(eventEntity.getPrice())
                .createdAt(eventEntity.getCreatedAt())
                .updatedAt(eventEntity.getUpdatedAt())
                .build();

    }

    public static EventEntity toEntity(CreateEventDTO createEventDTO) {
        return EventEntity.builder()
                .description(createEventDTO.getDescription())
                .type(EnumEventType.getById(createEventDTO.getType()))
                .dateTime(createEventDTO.getDateTime())
                .startingSales(createEventDTO.getStartingSales())
                .endingSales(createEventDTO.getEndingSales())
                .price(createEventDTO.getPrice())
                .build();
    }

}