package br.ufop.edu.web.ticket.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ufop.edu.web.ticket.user.converter.UserConverter;
import br.ufop.edu.web.ticket.user.dtos.SimpleUserRecordDTO;
import br.ufop.edu.web.ticket.user.models.UserModel;
import br.ufop.edu.web.ticket.user.repositories.IUserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
    private final IUserRepository userRepository;

    public List<SimpleUserRecordDTO> getAllUsers() {

        List<UserModel> userModelList = userRepository.findAll();

        return userModelList
            .stream()
            .map(UserConverter::toSimpleUserRecordDTO)
            .toList();

    }


}
