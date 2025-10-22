package br.edu.ufop.web.users.domain;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CCNetworkDomain {

    private UUID id;
    private String name;
    
}
