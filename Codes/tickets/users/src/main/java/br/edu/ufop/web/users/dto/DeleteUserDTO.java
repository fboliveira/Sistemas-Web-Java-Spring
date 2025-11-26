package br.edu.ufop.web.users.dto;

import java.util.UUID;

public record DeleteUserDTO(UUID id,
                            String password) {
}
