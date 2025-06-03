package br.ufop.edu.web.ticket.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufop.edu.web.ticket.user.models.UserModel;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    
}
