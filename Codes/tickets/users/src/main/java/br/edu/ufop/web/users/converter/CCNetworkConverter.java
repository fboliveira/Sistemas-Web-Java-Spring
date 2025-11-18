package br.edu.ufop.web.users.converter;

import br.edu.ufop.web.users.domain.CCNetworkDomain;
import br.edu.ufop.web.users.dto.CreateCreditCardNetworkDTO;
import br.edu.ufop.web.users.dto.CreditCardNetworkDTO;
import br.edu.ufop.web.users.entity.CCNetworkEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CCNetworkConverter {

    // DTO de entrada para classe do domínio
    public static CCNetworkDomain toDomain(CreateCreditCardNetworkDTO createCreditCardNetworkDTO) {
        return CCNetworkDomain.builder()
                .name(createCreditCardNetworkDTO.name())
                .build();
    }

    // Classe do domínio para entidade JPA
    public static CCNetworkEntity toEntity(CCNetworkDomain ccNetworkDomain) {
        return CCNetworkEntity.builder()
                .id(ccNetworkDomain.getId())
                .name(ccNetworkDomain.getName())
                .build();
    }

    // Entidade JPA para DTO de saída
    public static CreditCardNetworkDTO toDto(CCNetworkEntity ccNetworkEntity) {
        return new CreditCardNetworkDTO(
                ccNetworkEntity.getId(),
                ccNetworkEntity.getName()
        );
    }

    // Da Entidade JPA para o Domínio
    public static CCNetworkDomain toDomain(CCNetworkEntity ccNetworkEntity) {
        return CCNetworkDomain.builder()
                .id(ccNetworkEntity.getId())
                .name(ccNetworkEntity.getName())
                .build();
    }















}
