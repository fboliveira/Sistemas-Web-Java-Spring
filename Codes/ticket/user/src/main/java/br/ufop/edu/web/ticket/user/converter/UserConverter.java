package br.ufop.edu.web.ticket.user.converter;

import br.ufop.edu.web.ticket.user.dtos.SimpleUserRecordDTO;
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
    
}
