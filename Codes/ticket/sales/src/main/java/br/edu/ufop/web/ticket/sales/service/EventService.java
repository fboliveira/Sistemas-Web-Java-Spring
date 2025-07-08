package br.edu.ufop.web.ticket.sales.service;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.ticket.sales.dtos.events.CreateEventDTO;
import br.edu.ufop.web.ticket.sales.dtos.events.EventDTO;
import br.edu.ufop.web.ticket.sales.repositories.IEventRepository;

@Service
public class EventService {
    
    private final IEventRepository eventRepository;

    public EventDTO create(CreateEventDTO createEventDTO) {

        

    }

}
