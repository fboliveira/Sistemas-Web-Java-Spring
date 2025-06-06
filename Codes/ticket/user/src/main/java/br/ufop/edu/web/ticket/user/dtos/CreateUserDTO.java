package br.ufop.edu.web.ticket.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    
    private String name;

    private String creditCardNumber;

    private String email;
    private String password;

}
