package br.edu.ufop.web.sales.business.services;

import br.edu.ufop.web.sales.business.converters.SaleConverter;
import br.edu.ufop.web.sales.controller.dtos.sales.CreateSaleDTO;
import br.edu.ufop.web.sales.controller.dtos.sales.SaleDTO;
import br.edu.ufop.web.sales.infrastructure.entities.SaleEntity;
import br.edu.ufop.web.sales.infrastructure.repositories.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final ISaleRepository saleRepository;

    public List<SaleDTO> getAll() {

        List<SaleEntity> saleEntityList = saleRepository.findAll();

        return saleEntityList.stream()
                .map(SaleConverter::toDTO)
                .toList();

    }

    public SaleDTO create(CreateSaleDTO createSaleDTO) {

        SaleEntity eventEntity = SaleConverter.toEntity(createSaleDTO);
        eventEntity = saleRepository.save(eventEntity);
        return SaleConverter.toDTO(eventEntity);

    }

}
