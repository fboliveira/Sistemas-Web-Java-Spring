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

@RequiredArgsConstructor
@Component
public class CCNRepositoryAdapter implements CCNRepositoryPort {

    private final ICreditCardNetworkRepository repository;

    @Override
    public Optional<CCNetworkDomain> findById(UUID id) {
        Optional<CCNetworkEntity> optional = repository.findById(id);

        if (optional.isEmpty()) {
            return Optional.empty();
        }

        CCNetworkDomain domain = CCNetworkConverter.toDomain(optional.get());

        return Optional.of(domain);

    }

}
