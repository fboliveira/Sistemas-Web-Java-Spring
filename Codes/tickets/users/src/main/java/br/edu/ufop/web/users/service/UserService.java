package br.edu.ufop.web.users.service;

import br.edu.ufop.web.users.converter.UserConverter;
import br.edu.ufop.web.users.domain.UserDomain;
import br.edu.ufop.web.users.domain.usecase.CreateUserUseCase;
import br.edu.ufop.web.users.dto.CreateUserDTO;
import br.edu.ufop.web.users.dto.UserDTO;
import br.edu.ufop.web.users.entity.UserEntity;
import br.edu.ufop.web.users.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final IUserRepository repository;
    private final CreateUserUseCase useCase;

    public List<UserDTO> getAll() {
        return repository.findAll().stream().map(UserConverter::toUserDTO).toList();
    }

    public UserDTO save(CreateUserDTO dto) {

        UserDomain domain = UserConverter.toUserDomain(dto);

        useCase.setUserDomain(domain);
        useCase.validate();

        UserEntity entity = repository.save( UserConverter.toUserEntity(domain));

        return UserConverter.toUserDTO(entity);

    }

}
