package br.edu.ufop.web.users.service;

import br.edu.ufop.web.users.converter.UserConverter;
import br.edu.ufop.web.users.domain.UserDomain;
import br.edu.ufop.web.users.domain.usecase.CreateUserUseCase;
import br.edu.ufop.web.users.dto.CreateUserDTO;
import br.edu.ufop.web.users.dto.UserDTO;
import br.edu.ufop.web.users.entity.UserEntity;
import br.edu.ufop.web.users.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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














}
