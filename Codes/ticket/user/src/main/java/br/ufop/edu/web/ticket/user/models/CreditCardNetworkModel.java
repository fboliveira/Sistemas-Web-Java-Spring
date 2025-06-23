package br.ufop.edu.web.ticket.user.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_credit_card_network")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardNetworkModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    // ...

}
