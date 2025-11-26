package br.edu.ufop.web.users.repository;

import br.edu.ufop.web.users.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByName(String name);
    List<UserEntity> findAllByNameContainingIgnoreCase(String name);

    @Query(value = "SELECT * FROM tb_users u WHERE u.name LIKE %:name%", nativeQuery = true)
    List<UserEntity> findAllNameLike(@Param("name") String name);










}
