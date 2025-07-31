package br.edu.ufop.web.ticket.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.ticket.sales.converter.EventConverter;
import br.edu.ufop.web.ticket.sales.domain.EventDomain;
import br.edu.ufop.web.ticket.sales.domain.usecases.events.CreateEventUseCase;
import br.edu.ufop.web.ticket.sales.dtos.events.CreateEventDTO;
import br.edu.ufop.web.ticket.sales.dtos.events.EventDTO;
import br.edu.ufop.web.ticket.sales.model.EventModel;
import br.edu.ufop.web.ticket.sales.repositories.IEventRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService {
    
    private final IEventRepository eventRepository;

    public List<EventDTO> getAll() {
        return eventRepository.findAll().stream().map(EventConverter::toEventDTO).toList();
    }

    public EventDTO create(CreateEventDTO createEventDTO) {

        EventDomain eventDomain = EventConverter.toEventDomain(createEventDTO);
        CreateEventUseCase createEventUseCase = new CreateEventUseCase(eventDomain);
        createEventUseCase.validate();

        EventModel eventModel = EventConverter.toEventModel(eventDomain);

        return EventConverter.toEventDTO( eventRepository.save(eventModel) );

    }

}
