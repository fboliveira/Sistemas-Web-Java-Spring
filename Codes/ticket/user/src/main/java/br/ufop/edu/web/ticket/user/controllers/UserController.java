package br.ufop.edu.web.ticket.user.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.edu.web.ticket.user.dtos.SimpleUserRecordDTO;
import br.ufop.edu.web.ticket.user.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    
    @GetMapping("/users/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Service is running");
    }

    @GetMapping("/users")
    public ResponseEntity<List<SimpleUserRecordDTO>> getAllUsers() {

        List<SimpleUserRecordDTO> list =
            userService.getAllUsers();
        return ResponseEntity.ok(list);

    }

}
