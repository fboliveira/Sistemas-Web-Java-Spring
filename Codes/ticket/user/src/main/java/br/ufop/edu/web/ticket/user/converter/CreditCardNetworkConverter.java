package br.ufop.edu.web.ticket.user.converter;

import br.ufop.edu.web.ticket.user.domain.CreditCardNetworkDomain;
import br.ufop.edu.web.ticket.user.dtos.creditcardnetwork.CreateCreditCardNetworkDTO;
import br.ufop.edu.web.ticket.user.dtos.creditcardnetwork.SimpleCreditCardNetworkDTO;
import br.ufop.edu.web.ticket.user.models.CreditCardNetworkModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCardNetworkConverter {
    
    // Conversão do modelo (jpa) para o DTO de saída
    public static SimpleCreditCardNetworkDTO
        toSimpleCreditCardNetworkDTO(CreditCardNetworkModel creditCardNetworkModel) {
            return new SimpleCreditCardNetworkDTO(
                creditCardNetworkModel.getId(),
                creditCardNetworkModel.getName()
            );
        }

    // Conversão do DTO de criação para o domínio
    public static CreditCardNetworkDomain toCreditCardNetworkDomain(
        CreateCreditCardNetworkDTO createCreditCardNetworkDTO
    ) {
        return CreditCardNetworkDomain.builder()
            .name(createCreditCardNetworkDTO.name())
            .build();
    }

    // Conversão do domínio para o modelo
    public static CreditCardNetworkModel toCreditCardNetworkModel(
        CreditCardNetworkDomain creditCardNetworkDomain
    ) {
        return CreditCardNetworkModel.builder()
            .id(creditCardNetworkDomain.getId())
            .name(creditCardNetworkDomain.getName())
            .build();
    }

}
