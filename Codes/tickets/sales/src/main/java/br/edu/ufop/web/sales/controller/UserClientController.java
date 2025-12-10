package br.edu.ufop.web.sales.controller;

import br.edu.ufop.web.sales.business.services.clients.UserServiceClient;
import br.edu.ufop.web.sales.business.services.clients.dtos.UserServiceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients/users")
public class UserClientController {

    private final UserServiceClient userServiceClient;

    @GetMapping
    public ResponseEntity<List<UserServiceDTO>> getAll() {
        return ResponseEntity.ok(userServiceClient.getAllUsers());
    }











}
