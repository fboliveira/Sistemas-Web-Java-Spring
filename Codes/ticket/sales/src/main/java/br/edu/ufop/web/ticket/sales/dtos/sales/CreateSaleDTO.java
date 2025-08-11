package br.edu.ufop.web.ticket.sales.dtos.sales;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateSaleDTO {

    private UUID userId;
    private UUID eventId;
        
}
