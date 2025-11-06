package br.edu.ufop.web.users.controller;

import br.edu.ufop.web.users.dto.CreditCardNetworkDTO;
import br.edu.ufop.web.users.service.CCNetworkService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ccn")
@AllArgsConstructor
public class CCNetworkController {

    private final CCNetworkService service;

    @GetMapping
    public ResponseEntity<List<CreditCardNetworkDTO>> getAll() {

        return ResponseEntity.ok(service.getAll());

    }







}
