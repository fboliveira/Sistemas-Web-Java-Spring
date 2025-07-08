package br.edu.ufop.web.ticket.sales.domain.usecases.events;

import br.edu.ufop.web.ticket.sales.dtos.events.CreateEventDTO;
import br.edu.ufop.web.ticket.sales.enums.EnumEventType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateEventUseCase {
    
    CreateEventDTO createEventDTO;

    public void validate() {
        validateType();
    }

    private void validateType() {
        if (createEventDTO.getType() == null || createEventDTO.getType() >= EnumEventType.values().length) {
            createEventDTO.setType(EnumEventType.EVENTO.getId());
        }
    }

}
