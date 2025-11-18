package br.edu.ufop.web.users.dto;

import java.util.UUID;

public record CreateUserDTO(String name,
                            String email,
                            String password,
                            String creditCardNumber,
                            UUID creditCardNetworkId,
                            String city) {
}
