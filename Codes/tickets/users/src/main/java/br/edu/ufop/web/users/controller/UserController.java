package br.edu.ufop.web.users.controller;

import br.edu.ufop.web.users.dto.CreateUserDTO;
import br.edu.ufop.web.users.dto.DeleteUserDTO;
import br.edu.ufop.web.users.dto.UpdateUserDTO;
import br.edu.ufop.web.users.dto.UserDTO;
import br.edu.ufop.web.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("User service is running");
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(
            @RequestBody CreateUserDTO createUserDTO) {

        return ResponseEntity.ok(userService.create(createUserDTO));

    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getById(@PathVariable(value = "userId") UUID id) {

        Optional<UserDTO> userDTOOptional = userService.getById(id);

        if (userDTOOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userDTOOptional.get());


    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserDTO>> getByName(@PathVariable(value = "name") String name) {

        List<UserDTO> userDTOList = userService.getByName(name);

        return userDTOList.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(userDTOList);

    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(
            @RequestBody UpdateUserDTO updateUserDTO
            ) {

        UserDTO userDTO = userService.updateUser(updateUserDTO);
        return ResponseEntity.ok(userDTO);

    }

    // Put e-mail, password (antiga e nova), número do cartão de crédito,
    // bandeira do cartão de crédito

    // Delete
    @DeleteMapping
    public ResponseEntity<Void> delete(
            @RequestBody DeleteUserDTO deleteUserDTO
            ) {
        userService.delete(deleteUserDTO);
        return ResponseEntity.ok().build();
    }












}
