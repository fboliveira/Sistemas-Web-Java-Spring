package br.edu.ufop.web.users.domain.port;

import java.util.Optional;

public interface RepositoryPort<I, D> {

    Optional<D> findById(I id);

}
