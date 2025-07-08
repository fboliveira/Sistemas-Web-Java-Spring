package br.edu.ufop.web.ticket.sales.dtos.external.users;

import java.util.UUID;

public record UserDTO(UUID id, String name, String email) {
    
}
