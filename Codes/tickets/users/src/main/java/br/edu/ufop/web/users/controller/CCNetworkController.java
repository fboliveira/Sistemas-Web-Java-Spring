package br.edu.ufop.web.users.controller;

import br.edu.ufop.web.users.dto.CreateCreditCardNetworkDTO;
import br.edu.ufop.web.users.dto.CreditCardNetworkDTO;
import br.edu.ufop.web.users.service.CCNetworkService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<CreditCardNetworkDTO>
        create(@RequestBody CreateCreditCardNetworkDTO dto) {

        CreditCardNetworkDTO dtoRetorno = service.create(dto);

        if (dtoRetorno == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(dtoRetorno);

    }







}
