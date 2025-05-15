package br.ufop.edu.web.ticket.user.dtos;

import java.util.UUID;

public record SimpleUserRecordDTO(UUID id, String name, String email) {
    
}
