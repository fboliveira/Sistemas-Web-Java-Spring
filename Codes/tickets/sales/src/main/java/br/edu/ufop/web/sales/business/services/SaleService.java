package br.edu.ufop.web.sales.business.services;

import br.edu.ufop.web.sales.business.converters.SaleConverter;
import br.edu.ufop.web.sales.controller.dtos.sales.CreateSaleDTO;
import br.edu.ufop.web.sales.controller.dtos.sales.SaleDTO;
import br.edu.ufop.web.sales.infrastructure.entities.EventEntity;
import br.edu.ufop.web.sales.infrastructure.entities.SaleEntity;
import br.edu.ufop.web.sales.infrastructure.repositories.ISaleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final ISaleRepository saleRepository;
    private final EventService eventService;

    public List<SaleDTO> getAll() {

        List<SaleEntity> saleEntityList = saleRepository.findAll();

        return saleEntityList.stream()
                .map(SaleConverter::toDTO)
                .toList();

    }

    @Transactional
    public SaleDTO create(CreateSaleDTO createSaleDTO) {

        SaleEntity saleEntity = SaleConverter.toEntity(createSaleDTO);

        Optional<EventEntity> eventEntityOptional = eventService.getById(createSaleDTO.getEventId());

        if (eventEntityOptional.isEmpty()) {
            throw new RuntimeException("Event does not exists.");
        }

        saleEntity.setEvent(eventEntityOptional.get());

        saleRepository.save(saleEntity);
        return SaleConverter.toDTO(saleEntity);

    }

}
