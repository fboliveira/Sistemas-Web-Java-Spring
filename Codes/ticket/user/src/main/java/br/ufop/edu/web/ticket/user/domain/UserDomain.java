package br.ufop.edu.web.ticket.user.domain;

import java.time.LocalDateTime;
import java.util.UUID;

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
public class UserDomain {

    private UUID id;
    private String name;

    // ...

    private String creditCardNumber;

    private String email;
    private String password;

    private String city;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
