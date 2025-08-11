package br.edu.ufop.web.ticket.sales.converter;

import br.edu.ufop.web.ticket.sales.domain.EventDomain;
import br.edu.ufop.web.ticket.sales.domain.SaleDomain;
import br.edu.ufop.web.ticket.sales.dtos.sales.CreateSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.sales.SaleDTO;
import br.edu.ufop.web.ticket.sales.model.SaleModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SalesConverter {
    
    public static SaleDomain toSaleDomain(CreateSaleDTO createSaleDTO) {

        EventDomain eventDomain = EventDomain.builder()
            .id(createSaleDTO.getEventId())
            .build();

        return SaleDomain.builder()
            .userId(createSaleDTO.getUserId())
            .eventDomain(eventDomain)
            .build();

    }

    public static SaleModel toSaleModel(SaleDomain saleDomain) {

        return SaleModel.builder()
            .id(saleDomain.getId())
            .userId(saleDomain.getUserId())
            .eventModel(EventConverter.toEventModel(saleDomain.getEventDomain()))
            .saleDate(saleDomain.getSaleDate())
            .saleStatus(saleDomain.getSaleStatus())
            .build();

    }

    public static SaleDTO toSaleDTO(SaleModel saleModel) {

        return SaleDTO.builder()
            .id(saleModel.getId())
            .userId(saleModel.getUserId())
            .eventDTO(EventConverter.toEventDTO(saleModel.getEventModel()))
            .saleDate(saleModel.getSaleDate())
            .saleStatus(saleModel.getSaleStatus())
            .createdAt(saleModel.getCreatedAt())
            .updatedAt(saleModel.getUpdatedAt())
            .build();

    }

}
