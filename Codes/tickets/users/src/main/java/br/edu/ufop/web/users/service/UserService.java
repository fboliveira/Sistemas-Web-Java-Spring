package br.edu.ufop.web.users.service;

import br.edu.ufop.web.users.converter.UserConverter;
import br.edu.ufop.web.users.domain.UserDomain;
import br.edu.ufop.web.users.domain.usecase.CreateUserUseCase;
import br.edu.ufop.web.users.dto.CreateUserDTO;
import br.edu.ufop.web.users.dto.DeleteUserDTO;
import br.edu.ufop.web.users.dto.UpdateUserDTO;
import br.edu.ufop.web.users.dto.UserDTO;
import br.edu.ufop.web.users.entity.UserEntity;
import br.edu.ufop.web.users.exception.UseCaseException;
import br.edu.ufop.web.users.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository repository;
    private final CreateUserUseCase useCase;

    public List<UserDTO> getAll() {

        List<UserEntity> userEntityList = repository.findAll();

        return userEntityList.stream()
                .map(UserConverter::toUserDTO)
                .toList();

    }

    public UserDTO create(CreateUserDTO createUserDTO) {

        UserDomain userDomain = UserConverter.toUserDomain(createUserDTO);

        // Invocar o use case - create
        useCase.setUserDomain(userDomain);
        useCase.validate();

        UserEntity entity = repository.save(
                UserConverter.toUserEntity(userDomain)
        );

        return UserConverter.toUserDTO(entity);

    }

    public Optional<UserDTO> getById(UUID id) {
        Optional<UserEntity> userEntityOptional = repository.findById(id);

        if (userEntityOptional.isEmpty()){
            return Optional.empty();
        }

        UserDTO userDTO = UserConverter.toUserDTO(userEntityOptional.get());
        return Optional.of(userDTO);


    }

    public List<UserDTO> getByName(String name) {

        List<UserEntity> userEntityList = repository.findAllByNameContainingIgnoreCase(name);

//        List<UserEntity> userEntityList = repository.findAllNameLike(name);

        return userEntityList.stream()
                .map(UserConverter::toUserDTO)
                .toList();

    }

    public UserDTO updateUser(UpdateUserDTO updateUserDTO) {

        // UseCase -> porta: domain para entity
        // Identificar se o ID é válido.
        Optional<UserEntity> userEntityOptional = repository.findById(updateUserDTO.id());

        if (userEntityOptional.isEmpty()) {
            throw new UseCaseException("User ID does not found.");
        }

        UserEntity userEntity = userEntityOptional.get();

        // Update -> use case
        userEntity.setName(updateUserDTO.name());
        userEntity.setCity(updateUserDTO.city());

        repository.save(userEntity);

        return UserConverter.toUserDTO(userEntity);


    }

    public void delete(DeleteUserDTO deleteUserDTO) {

        Optional<UserEntity> userEntityOptional = repository.findById(deleteUserDTO.id());

        if (userEntityOptional.isEmpty()) {
            throw new UseCaseException("User ID does not found.");
        }

        UserEntity userEntity = userEntityOptional.get();

        if (!userEntity.getPassword().equals(deleteUserDTO.password())) {
            throw new UseCaseException("Invalid password.");
        }

        repository.delete(userEntity);

    }














}
