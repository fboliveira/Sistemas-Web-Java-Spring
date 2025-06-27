package br.ufop.edu.web.ticket.user.models;

import java.time.LocalDateTime;
import java.util.UUID;

import br.ufop.edu.web.ticket.user.enums.EnumUserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_users")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String creditCardNumber;

    private String email;
    private String password;

    @Column(nullable = true) // true - default; false - not null
    private String city;    

    @ManyToOne
    @JoinColumn(name = "credit_card_network_id")
    private CreditCardNetworkModel creditCardNetworkModel;

    private EnumUserType userType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void antesGravar() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void antesAtualizar(){
        this.updatedAt = LocalDateTime.now();
    }

}
