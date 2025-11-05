package br.edu.ufop.web.users.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_credit_card_network",
    indexes = {
        @Index(name = "idx_ccn_name", columnList = "name ASC")
    })

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CCNetworkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, columnDefinition = "varchar(100)")
    private String name;

    private String comment;

    private Double tax;












}
