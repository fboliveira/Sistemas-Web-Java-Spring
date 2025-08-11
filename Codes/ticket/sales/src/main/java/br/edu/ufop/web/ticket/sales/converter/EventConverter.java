package br.edu.ufop.web.ticket.sales.converter;

import br.edu.ufop.web.ticket.sales.domain.EventDomain;
import br.edu.ufop.web.ticket.sales.dtos.events.CreateEventDTO;
import br.edu.ufop.web.ticket.sales.dtos.events.EventDTO;
import br.edu.ufop.web.ticket.sales.enums.EnumEventType;
import br.edu.ufop.web.ticket.sales.model.EventModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventConverter {
    
    public static EventModel toEventModel(EventDomain eventDomain) {

        return EventModel.builder()
            .id(eventDomain.getId())
            .description(eventDomain.getDescription())
            .type(eventDomain.getType())
            .date(eventDomain.getDate())
            .startSales(eventDomain.getStartSales())
            .endSales(eventDomain.getEndSales())
            .price(eventDomain.getPrice())
            .createdAt(eventDomain.getCreatedAt())
            .updatedAt(eventDomain.getUpdatedAt())
            .build();
    }

    public static EventDomain toEventDomain(EventModel eventModel) {

        return EventDomain.builder()
            .id(eventModel.getId())
            .description(eventModel.getDescription())
            .type(eventModel.getType())
            .date(eventModel.getDate())
            .startSales(eventModel.getStartSales())
            .endSales(eventModel.getEndSales())
            .price(eventModel.getPrice())
            .createdAt(eventModel.getCreatedAt())
            .updatedAt(eventModel.getUpdatedAt())
            .build();
    }

    public static EventDTO toEventDTO(EventModel eventModel) {

        return EventDTO.builder()
            .id(eventModel.getId())
            .description(eventModel.getDescription())
            .type(eventModel.getType())
            .date(eventModel.getDate())
            .startSales(eventModel.getStartSales())
            .endSales(eventModel.getEndSales())
            .price(eventModel.getPrice())
            .createdAt(eventModel.getCreatedAt())
            .updatedAt(eventModel.getUpdatedAt())
            .build();
    }

        public static EventDomain toEventDomain(CreateEventDTO createEventDTO) {

        EnumEventType enumEventType = null;

        for (EnumEventType item : EnumEventType.values()) {
            if (item.getId() == createEventDTO.getType()) {
                enumEventType = item;
                break;
            }
        }

        return EventDomain.builder()
            .id(null)
            .description(createEventDTO.getDescription())
            .type(enumEventType)
            .date(createEventDTO.getDate())
            .startSales(createEventDTO.getStartSales())
            .endSales(createEventDTO.getEndSales())
            .price(createEventDTO.getPrice())
            .build();
    }


}
