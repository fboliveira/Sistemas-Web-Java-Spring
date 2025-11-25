package br.edu.ufop.web.users.domain.usecase;

import br.edu.ufop.web.users.domain.CCNetworkDomain;
import br.edu.ufop.web.users.domain.UserDomain;
import br.edu.ufop.web.users.domain.port.CCNRepositoryPort;
import br.edu.ufop.web.users.enums.EnumUserType;
import br.edu.ufop.web.users.exception.UseCaseException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;
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

        // Demais validações
        validateCCNetworkId();
        validateEMail();
        validadePassword();
        validadeUserType();

    }

    private void validateName() {
        if (this.userDomain.getName() == null) {
            throw new UseCaseException("Name is null");
        }
    }

    private void validateCCNetworkId() {

        if (this.userDomain.getCcNetwork() == null) {
            throw new UseCaseException("Invalid Credit Card Network");
        }

        UUID id = this.userDomain.getCcNetwork().getId();

        if (id == null) {
            throw new UseCaseException("Credit Card Network ID is null");
        }

        Optional<CCNetworkDomain> domainOptional = repositoryPort.findById(id);

        if (domainOptional.isEmpty()) {
            throw new UseCaseException("Credit Card Network ID does not exist.");
        }

        this.userDomain.setCcNetwork(domainOptional.get());


    }

    private void validateEMail() {
        if (this.userDomain.getEmail() == null) {
            throw new UseCaseException("E-mail is null.");
        }
    }

    private void validadePassword() {
        if (this.userDomain.getPassword() == null) {
            throw new UseCaseException("Password is null");
        }
    }

    private void validadeUserType() {
        if (Objects.isNull(this.userDomain.getType())) {
            this.userDomain.setType(EnumUserType.CUSTOMER);
        }
    }










}
