package br.edu.ufop.web.users.domain.usecase;

import br.edu.ufop.web.users.domain.UserDomain;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class CreateUserUseCase {

    private UserDomain userDomain;

    public void validate() {
        // Validações conforme a regra de negócio para a criação do usuário
        validateName();

        // Demais validações

    }

    private void validateName() {
        if (this.userDomain.getName() == null) {
            throw new RuntimeException("Name is null");
        }
    }












}
