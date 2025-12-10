package br.edu.ufop.web.sales.business.services;

import br.edu.ufop.web.sales.business.converters.EventConverter;
import br.edu.ufop.web.sales.controller.dtos.events.CreateEventDTO;
import br.edu.ufop.web.sales.controller.dtos.events.EventDTO;
import br.edu.ufop.web.sales.infrastructure.entities.EventEntity;
import br.edu.ufop.web.sales.infrastructure.repositories.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final IEventRepository eventRepository;

    public List<EventDTO> getAll() {

        List<EventEntity> eventEntityList = eventRepository.findAll();

        return eventEntityList.stream()
                .map(EventConverter::toDTO)
                .toList();

    }

    public EventDTO create(CreateEventDTO createEventDTO) {

        EventEntity eventEntity = EventConverter.toEntity(createEventDTO);
        eventEntity = eventRepository.save(eventEntity);
        return EventConverter.toDTO(eventEntity);

    }

    public Optional<EventEntity> getById(UUID id) {
        return eventRepository.findById(id);
    }

}
