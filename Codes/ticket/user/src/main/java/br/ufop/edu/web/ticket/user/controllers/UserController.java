package br.ufop.edu.web.ticket.user.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.edu.web.ticket.user.dtos.CreateUserDTO;
import br.ufop.edu.web.ticket.user.dtos.SimpleUserRecordDTO;
import br.ufop.edu.web.ticket.user.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Service is running");
    }

    @GetMapping
    public ResponseEntity<List<SimpleUserRecordDTO>> getAllUsers() {

        List<SimpleUserRecordDTO> list =
            userService.getAllUsers();
        return ResponseEntity.ok(list);

    }

    @PostMapping
    public ResponseEntity<SimpleUserRecordDTO> 
        createUser(@RequestBody 
            CreateUserDTO createUserDTO) {
        
        SimpleUserRecordDTO simpleUserRecordDTO = userService.createUser(createUserDTO);
        return ResponseEntity.ok(simpleUserRecordDTO);
    }    


}
