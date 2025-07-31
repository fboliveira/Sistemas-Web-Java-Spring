package br.edu.ufop.web.ticket.sales.dtos.events;

import java.time.LocalDateTime;
import java.util.UUID;
import br.edu.ufop.web.ticket.sales.enums.EnumEventType;
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
public class EventDTO {
 
    private UUID id;

    private String description;
    
    private EnumEventType type;
    
    private LocalDateTime date;
    
    private LocalDateTime startSales;
    private LocalDateTime endSales;
    
    private Float price;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;  
    
}
