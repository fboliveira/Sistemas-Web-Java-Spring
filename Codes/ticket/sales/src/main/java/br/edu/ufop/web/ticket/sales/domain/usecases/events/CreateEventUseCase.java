package br.edu.ufop.web.ticket.sales.domain.usecases.events;

import br.edu.ufop.web.ticket.sales.domain.EventDomain;
import br.edu.ufop.web.ticket.sales.enums.EnumEventType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateEventUseCase {
    
    EventDomain eventDomain;

    public void validate() {
        validateType();
    }

    private void validateType() {
        if (eventDomain.getType() == null) {
            eventDomain.setType(EnumEventType.EVENTO);
        }
    }

}
