package br.ufop.edu.web.ticket.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.ufop.edu.web.ticket.user.converter.UserConverter;
import br.ufop.edu.web.ticket.user.domain.UserDomain;
import br.ufop.edu.web.ticket.user.domain.usecase.CreateUserUseCase;
import br.ufop.edu.web.ticket.user.domain.usecase.UpdateUserPasswordUseCase;
import br.ufop.edu.web.ticket.user.dtos.CreateUserDTO;
import br.ufop.edu.web.ticket.user.dtos.DeleteUserDTO;
import br.ufop.edu.web.ticket.user.dtos.SimpleUserRecordDTO;
import br.ufop.edu.web.ticket.user.dtos.UpdateUserCreditCardDTO;
import br.ufop.edu.web.ticket.user.dtos.UpdateUserDTO;
import br.ufop.edu.web.ticket.user.dtos.UpdateUserPasswordDTO;
import br.ufop.edu.web.ticket.user.models.CreditCardNetworkModel;
import br.ufop.edu.web.ticket.user.models.UserModel;
import br.ufop.edu.web.ticket.user.repositories.ICreditCardNetworkRepository;
import br.ufop.edu.web.ticket.user.repositories.IUserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
    private final IUserRepository userRepository;
    private final ICreditCardNetworkRepository creditCardNetworkRepository;

    public List<SimpleUserRecordDTO> getAllUsers() {

        List<UserModel> userModelList = userRepository.findAll();

        return userModelList
            .stream()
            .map(UserConverter::toSimpleUserRecordDTO)
            .toList();

    }

    public SimpleUserRecordDTO createUser(CreateUserDTO createUserDTO) {

        UserDomain userDomain = UserConverter.toUserDomain(createUserDTO);

        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userDomain);
        createUserUseCase.validate();

        UserModel userModel = UserConverter.toUserModel(userDomain);

        return UserConverter.toSimpleUserRecordDTO(userRepository.save(userModel));

    }

    public SimpleUserRecordDTO getUserById(String id) {
  
        UUID uuid = UUID.fromString(id);
        Optional<UserModel> optionalUserModel = 
            userRepository.findById(uuid);

        if (optionalUserModel.isEmpty()) {
            return null;
        }

        UserModel userModel = 
                optionalUserModel.get();
        return UserConverter.toSimpleUserRecordDTO(userModel);


    }

    public List<SimpleUserRecordDTO> getUsersByName(String userName) {

        List<UserModel> userModelList = userRepository.findAllByNameContainingIgnoreCase(userName);        
        
        return userModelList
            .stream()
            .map(UserConverter::toSimpleUserRecordDTO)
            .toList();


    }

    public SimpleUserRecordDTO updateUser(UpdateUserDTO updateUserDTO) {

        // Converter para uma entidade do domínio
        UserDomain userDomain = UserConverter.toUserDomain(updateUserDTO);

        // Validar conforme as usecases
        

        // Recuperar a entidade atual do banco de dados
        // Verificar se o ID existe
        Optional<UserModel> optionalUserModel = userRepository.findById(updateUserDTO.getId());

        if (optionalUserModel.isEmpty()) {
            return null;
        }

        UserModel userModel = UserConverter.toUserModel(userDomain);

        return UserConverter.toSimpleUserRecordDTO(userRepository.save(userModel));

    }

    public SimpleUserRecordDTO updateUserPassword(UpdateUserPasswordDTO updateUserPasswordDTO) {

        Optional<UserModel> optionalUserModel = userRepository.findById(updateUserPasswordDTO.getId());

        if (optionalUserModel.isEmpty()) {
            return null;
        }

        UserModel userModel = optionalUserModel.get();

        UpdateUserPasswordUseCase useCase = new UpdateUserPasswordUseCase(userModel.getEmail(), updateUserPasswordDTO.getEmail(), userModel.getPassword(), updateUserPasswordDTO.getOldPassword());
        useCase.validate();

        userModel.setPassword(updateUserPasswordDTO.getNewPassword());

        return UserConverter.toSimpleUserRecordDTO(userRepository.save(userModel));

    }

    public void deleteUser(DeleteUserDTO deleteUserDTO) {

        Optional<UserModel> optionalUserModel = userRepository
                .findById(deleteUserDTO.id());

        // Use case: tickets associados ...
        if (optionalUserModel.isEmpty()) {
            throw new RuntimeException("User not found.");
        }

        userRepository.delete(optionalUserModel.get());

    }

    public SimpleUserRecordDTO updateCreditCard(
        UpdateUserCreditCardDTO updateUserCreditCardDTO
    ) {

        Optional<UserModel> optional = userRepository
            .findById(updateUserCreditCardDTO.id());

        if (optional.isEmpty()) {
            return null;
        }

        Optional<CreditCardNetworkModel> optionalCCN =
            creditCardNetworkRepository.findById(updateUserCreditCardDTO.creditCardNetworkId());

        if (optionalCCN.isEmpty()) {
            return null;
        }

        UserModel userModel = optional.get();
        CreditCardNetworkModel creditCardNetworkModel = optionalCCN.get();

        userModel.setCreditCardNumber(updateUserCreditCardDTO.creditCardNumber());
        userModel.setCreditCardNetworkModel(creditCardNetworkModel);

        return UserConverter.toSimpleUserRecordDTO(
            userRepository.save(userModel)
        );

    }


}
