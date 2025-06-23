package br.ufop.edu.web.ticket.user.domain.creditcardnetwork.usecase;

import br.ufop.edu.web.ticket.user.domain.creditcardnetwork.CreditCardNetworkDomain;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class CreateCreditCardNetworkUseCase {

    CreditCardNetworkDomain creditCardNetworkDomain;

    public void validate() {

        // Regras de negócio - conforme com o caso de uso
        validateName();

        // Demais validações


    }

    private void validateName() {

        if (this.creditCardNetworkDomain.getName() == null) {
            throw new RuntimeException("Name is null");
        }


    }

}
