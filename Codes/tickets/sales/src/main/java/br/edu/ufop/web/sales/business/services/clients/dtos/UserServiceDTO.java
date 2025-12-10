package br.edu.ufop.web.sales.business.services.clients.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserServiceDTO {

    private UUID id;
    private String name;
    private String email;

}
