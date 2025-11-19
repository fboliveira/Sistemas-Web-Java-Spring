package br.edu.ufop.web.users.repository;

import br.edu.ufop.web.users.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserEntity, UUID> {

}
