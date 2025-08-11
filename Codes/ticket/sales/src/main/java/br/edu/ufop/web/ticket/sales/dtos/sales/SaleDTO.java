package br.edu.ufop.web.ticket.sales.dtos.sales;

import java.time.LocalDateTime;
import java.util.UUID;

import br.edu.ufop.web.ticket.sales.dtos.events.EventDTO;
import br.edu.ufop.web.ticket.sales.enums.EnumSaleStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDTO {
    private UUID id;

    private UUID userId;

    private EventDTO eventDTO;
    
    private LocalDateTime saleDate;
    
    private EnumSaleStatusType saleStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
