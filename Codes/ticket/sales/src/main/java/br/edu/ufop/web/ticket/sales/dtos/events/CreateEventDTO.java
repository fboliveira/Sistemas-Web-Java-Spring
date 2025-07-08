package br.edu.ufop.web.ticket.sales.dtos.events;

import java.time.LocalDateTime;

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
public class CreateEventDTO {
    
    private String description;
    
    private Integer type;
    
    private LocalDateTime date;
    
    private LocalDateTime startSales;
    private LocalDateTime endSales;
    
    private Float price;

}
