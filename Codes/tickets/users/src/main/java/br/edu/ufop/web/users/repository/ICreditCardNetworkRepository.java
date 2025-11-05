package br.edu.ufop.web.users.repository;

import br.edu.ufop.web.users.entity.CCNetworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICreditCardNetworkRepository extends JpaRepository<CCNetworkEntity, UUID> {


    List<CCNetworkEntity> findByName(String name);
    List<CCNetworkEntity> findByNameContainingIgnoreCase(String name);

    List<CCNetworkEntity> findByComment(String comment);

    List<CCNetworkEntity> findByTaxBefore(Double taxBefore);

    @Query(value = "SELECT cce FROM CCNetworkEntity cce " +
            "WHERE cce.tax = :tax")
    Optional<CCNetworkEntity> procurarPorTaxa(@Param("tax") Double tax);

    @Query(value = "select * from tb_credit_card_network " +
            " where tax = :tax ", nativeQuery = true)
    Optional<CCNetworkEntity> procurarPorTaxaSQLNativo(@Param("tax") Double tax);














}
