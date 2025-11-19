package br.edu.ufop.web.users.domain.usecase;

import br.edu.ufop.web.users.exception.CCNetworkNotFoundException;
import br.edu.ufop.web.users.domain.CCNetworkDomain;
import br.edu.ufop.web.users.domain.UserDomain;
import br.edu.ufop.web.users.domain.port.CCNRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CreateUserUseCase {

    @Setter
    private UserDomain userDomain;
    private final CCNRepositoryPort repositoryPort;

    public void validate() {
        // Validações conforme a regra de negócio para a criação do usuário
        validateName();
        validateCCNetwork();

        // Demais validações

    }

    private void validateName() {
        if (this.userDomain.getName() == null) {
            throw new RuntimeException("Name is null");
        }
    }

    private void validateCCNetwork() {

        if (this.userDomain.getCcNetwork() == null) {
            throw new RuntimeException("Credit Card Network is null");
        }

        UUID id = this.userDomain.getCcNetwork().getId();
        Optional<CCNetworkDomain> optional = repositoryPort.findById(id);

        if (optional.isEmpty()) {
            throw new CCNetworkNotFoundException("Credit Card Network does not found.");
        }


    }












}
