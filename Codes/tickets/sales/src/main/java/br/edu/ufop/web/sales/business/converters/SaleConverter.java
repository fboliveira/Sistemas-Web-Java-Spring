package br.edu.ufop.web.sales.business.converters;

import br.edu.ufop.web.sales.controller.dtos.sales.CreateSaleDTO;
import br.edu.ufop.web.sales.controller.dtos.sales.SaleDTO;
import br.edu.ufop.web.sales.infrastructure.entities.EventEntity;
import br.edu.ufop.web.sales.infrastructure.entities.SaleEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SaleConverter {

    public static SaleDTO toDTO(SaleEntity saleEntity) {
        return SaleDTO.builder()
                .id(saleEntity.getId())
                .userId(saleEntity.getUserId())
                .event(EventConverter.toDTO(saleEntity.getEvent()))
                .dateTime(saleEntity.getDateTime())
                .status(saleEntity.getStatus())
                .createdAt(saleEntity.getCreatedAt())
                .updatedAt(saleEntity.getUpdatedAt())
                .build();
    }

    public static SaleEntity toEntity(CreateSaleDTO createSaleDTO) {
        return SaleEntity.builder()
                .userId(createSaleDTO.getUserId())
                .event(EventEntity.builder().id(createSaleDTO.getEventId()).build())
                .build();
    }

}
