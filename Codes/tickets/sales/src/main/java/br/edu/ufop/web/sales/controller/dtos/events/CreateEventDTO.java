package br.edu.ufop.web.sales.controller.dtos.events;

import br.edu.ufop.web.sales.enums.EnumEventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEventDTO {

    private String description;

    private Integer type;

    private LocalDateTime dateTime;

    private LocalDateTime startingSales;
    private LocalDateTime endingSales;

    private Float price;

}
