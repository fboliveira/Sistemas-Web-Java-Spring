package br.ufop.edu.web.ticket.user.domain.usecase;

import br.ufop.edu.web.ticket.user.domain.UserDomain;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class CreateUserUseCase {
    
    UserDomain userDomain;

    public void validate() {

        // Regras de negócio - conforme com o caso de uso
        validateName();

        // Demais validações


    }

    private void validateName() {

        if (this.userDomain.getName() == null) {
            throw new RuntimeException("Name is null");
        }


    }

}
