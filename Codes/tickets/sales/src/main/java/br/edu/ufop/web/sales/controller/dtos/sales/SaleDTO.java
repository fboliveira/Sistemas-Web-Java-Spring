package br.edu.ufop.web.sales.controller.dtos.sales;

import br.edu.ufop.web.sales.controller.dtos.events.EventDTO;
import br.edu.ufop.web.sales.enums.EnumSaleStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDTO {

    private UUID id;
    private UUID userId;

    private EventDTO event;

    private LocalDateTime dateTime;

    private EnumSaleStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
