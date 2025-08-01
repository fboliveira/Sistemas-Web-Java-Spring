package br.edu.ufop.web.ticket.sales.dtos.externals;

import java.util.UUID;

public record UserDTO(
    UUID id,
    String name,
    String email
) {
    
}
