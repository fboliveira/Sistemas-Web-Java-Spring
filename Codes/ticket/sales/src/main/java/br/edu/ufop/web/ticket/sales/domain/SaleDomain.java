package br.edu.ufop.web.ticket.sales.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.edu.ufop.web.ticket.sales.enums.EnumSaleStatusType;
import br.edu.ufop.web.ticket.sales.model.EventModel;
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
public class SaleDomain {
    
    private UUID id;

    private UUID userId;

    private EventModel eventModel;
    
    private LocalDateTime saleDate;
    
    private EnumSaleStatusType saleStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
