package br.edu.ufop.web.sales.infrastructure.repositories;

import br.edu.ufop.web.sales.infrastructure.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IEventRepository extends JpaRepository<EventEntity, UUID> {

}
