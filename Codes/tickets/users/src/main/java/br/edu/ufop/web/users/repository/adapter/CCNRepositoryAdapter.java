package br.edu.ufop.web.users.repository.adapter;

import br.edu.ufop.web.users.converter.CCNetworkConverter;
import br.edu.ufop.web.users.domain.CCNetworkDomain;
import br.edu.ufop.web.users.domain.port.CCNRepositoryPort;
import br.edu.ufop.web.users.entity.CCNetworkEntity;
import br.edu.ufop.web.users.repository.ICreditCardNetworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CCNRepositoryAdapter implements CCNRepositoryPort {

    private final ICreditCardNetworkRepository repositoryJpa;

    @Override
    public Optional<CCNetworkDomain> findById(UUID id) {
        Optional<CCNetworkEntity> ccNetworkEntityOptional =
                repositoryJpa.findById(id);

        if (ccNetworkEntityOptional.isEmpty()) {
            return Optional.empty();
        }

        CCNetworkDomain domain = CCNetworkConverter.toDomain(
                ccNetworkEntityOptional.get()
        );

        return Optional.of(domain);

    }













}
