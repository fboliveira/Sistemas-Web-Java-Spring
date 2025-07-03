package br.ufop.edu.web.ticket.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufop.edu.web.ticket.user.models.UserModel;
import java.util.List;
import java.util.Optional;


public interface IUserRepository extends JpaRepository<UserModel, UUID> {

    List<UserModel> findByName(String name);
    List<UserModel> findByCity(String city);

    List<UserModel> findAllByNameContainingIgnoreCase(String name);

    Optional<UserModel> findByEmailAndPassword(String email, String password);
    
}
