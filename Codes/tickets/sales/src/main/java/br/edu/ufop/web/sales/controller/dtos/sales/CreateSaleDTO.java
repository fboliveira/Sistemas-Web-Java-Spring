package br.edu.ufop.web.sales.controller.dtos.sales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSaleDTO {

    private UUID userId;
    private UUID eventId;

}
