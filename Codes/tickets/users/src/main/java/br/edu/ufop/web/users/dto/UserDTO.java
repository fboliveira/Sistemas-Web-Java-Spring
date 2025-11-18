package br.edu.ufop.web.users.dto;

import java.util.UUID;

public record UserDTO(UUID id,
                      String name,
                      String email) {
}
