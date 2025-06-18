package br.ufop.edu.web.ticket.user.converter;

import br.ufop.edu.web.ticket.user.domain.UserDomain;
import br.ufop.edu.web.ticket.user.dtos.CreateUserDTO;
import br.ufop.edu.web.ticket.user.dtos.SimpleUserRecordDTO;
import br.ufop.edu.web.ticket.user.dtos.UpdateUserDTO;
import br.ufop.edu.web.ticket.user.models.UserModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {

    public static SimpleUserRecordDTO toSimpleUserRecordDTO(UserModel userModel) {
        return new SimpleUserRecordDTO(
            userModel.getId(),
            userModel.getName(),
            userModel.getEmail()
        );
    }

    public static UserDomain toUserDomain(CreateUserDTO createUserDTO) {

        return UserDomain.builder()
            .name(createUserDTO.getName())
            .creditCardNumber(createUserDTO.getCreditCardNumber())
            .email(createUserDTO.getEmail())
            .password(createUserDTO.getPassword())
            .city(createUserDTO.getCity())
            .build();

    }

    public static UserModel toUserModel(UserDomain userDomain) {
        return UserModel.builder()
            .id(userDomain.getId())
            .name(userDomain.getName())
            .creditCardNumber(userDomain.getCreditCardNumber())
            .email(userDomain.getEmail())
            .password(userDomain.getPassword())
            .city(userDomain.getCity())
            .build();

    }

    public static UserDomain toUserDomain(UpdateUserDTO updateUserDTO) {
        return UserDomain.builder()
            .id(updateUserDTO.getId())
            .name(updateUserDTO.getName())
            .creditCardNumber(updateUserDTO.getCreditCardNumber())
            .email(updateUserDTO.getEmail())
            .password(updateUserDTO.getPassword())
            .city(updateUserDTO.getCity())
            .build();
    }
    
}
