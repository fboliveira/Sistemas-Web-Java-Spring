package br.ufop.edu.web.ticket.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufop.edu.web.ticket.user.models.CreditCardNetworkModel;

public interface ICreditCardNetworkRepository
    extends JpaRepository<CreditCardNetworkModel, UUID> {
    
}
