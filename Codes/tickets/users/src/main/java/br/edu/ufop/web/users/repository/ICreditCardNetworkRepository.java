package br.edu.ufop.web.users.repository;

import br.edu.ufop.web.users.entity.CCNetworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ICreditCardNetworkRepository extends JpaRepository<CCNetworkEntity, UUID> {


    List<CCNetworkEntity> findByName(String name);
    List<CCNetworkEntity> findByNameContainingIgnoreCase(String name);













}
