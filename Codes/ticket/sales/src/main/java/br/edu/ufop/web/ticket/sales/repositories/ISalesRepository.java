package br.edu.ufop.web.ticket.sales.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufop.web.ticket.sales.model.SaleModel;

public interface ISalesRepository extends JpaRepository<SaleModel, UUID> {
    
}
