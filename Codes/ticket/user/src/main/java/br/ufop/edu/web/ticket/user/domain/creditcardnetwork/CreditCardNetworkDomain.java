package br.ufop.edu.web.ticket.user.domain.creditcardnetwork;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardNetworkDomain {

    private UUID id;
    private String name;

}
