package br.edu.ufop.web.users.domain.port;

import java.util.Optional;

public interface RepositoryPort<D, T> {

    Optional<D> findById(T id);

}
