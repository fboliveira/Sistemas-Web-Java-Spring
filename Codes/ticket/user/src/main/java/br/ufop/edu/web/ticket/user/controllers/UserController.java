package br.ufop.edu.web.ticket.user.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @GetMapping("/users/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Service is running");
    }

}
