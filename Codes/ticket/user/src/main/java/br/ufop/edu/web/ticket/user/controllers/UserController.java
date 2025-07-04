package br.ufop.edu.web.ticket.user.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.edu.web.ticket.user.dtos.CreateUserDTO;
import br.ufop.edu.web.ticket.user.dtos.DeleteUserDTO;
import br.ufop.edu.web.ticket.user.dtos.SimpleUserRecordDTO;
import br.ufop.edu.web.ticket.user.dtos.UpdateUserCreditCardDTO;
import br.ufop.edu.web.ticket.user.dtos.UpdateUserDTO;
import br.ufop.edu.web.ticket.user.dtos.UpdateUserPasswordDTO;
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
    
    @GetMapping("/{userId}")
    public ResponseEntity<SimpleUserRecordDTO>
        getUserById(@PathVariable(value = "userId") String id) {

            SimpleUserRecordDTO simpleUserRecordDTO =
            userService.getUserById(id);

            if (simpleUserRecordDTO == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(simpleUserRecordDTO);

        }

    @GetMapping("/byname/{name}")
    public ResponseEntity<List<SimpleUserRecordDTO>> getByName(@PathVariable(value = "name") String userName) {

        List<SimpleUserRecordDTO> list =
            userService.getUsersByName(userName);
        return ResponseEntity.ok(list);

    }

    @PutMapping
    public ResponseEntity<SimpleUserRecordDTO> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {

        SimpleUserRecordDTO simpleUserRecordDTO = userService.updateUser(updateUserDTO);

        if (simpleUserRecordDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(simpleUserRecordDTO);

    }

    @PutMapping("/password")
    public ResponseEntity<SimpleUserRecordDTO> updateUserPassword(@RequestBody  UpdateUserPasswordDTO updateUserPasswordDTO) {

        SimpleUserRecordDTO simpleUserRecordDTO = userService.updateUserPassword(updateUserPasswordDTO);

        if (simpleUserRecordDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(simpleUserRecordDTO);

    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> deleteUser(@RequestBody DeleteUserDTO deleteUserDTO) {
        
        userService.deleteUser(deleteUserDTO);
        return ResponseEntity.ok("User has been deleted.");

    }

    @PutMapping("/creditcard")
    public ResponseEntity<SimpleUserRecordDTO> updateCreditCard(
        @RequestBody UpdateUserCreditCardDTO updateUserCreditCardDTO
    ) {

        SimpleUserRecordDTO simpleUserRecordDTO = 
            userService.updateCreditCard(updateUserCreditCardDTO);

        if (simpleUserRecordDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(simpleUserRecordDTO);

    }



}
