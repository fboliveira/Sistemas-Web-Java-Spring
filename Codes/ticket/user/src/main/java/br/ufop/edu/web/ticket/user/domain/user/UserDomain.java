package br.ufop.edu.web.ticket.user.domain.user;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AccessLevel;
import br.ufop.edu.web.ticket.user.domain.CreditCardNetworkDomain;
import br.ufop.edu.web.ticket.user.enums.EnumUserType;
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

    @Setter(AccessLevel.NONE)
    private String creditCardNumber;

    private String email;
    private String password;

    private String city;

    private CreditCardNetworkDomain creditCardNetworkDomain;

    private EnumUserType userType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
