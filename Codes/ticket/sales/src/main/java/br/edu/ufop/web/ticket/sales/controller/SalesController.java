package br.edu.ufop.web.ticket.sales.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufop.web.ticket.sales.dtos.externals.UserDTO;
import br.edu.ufop.web.ticket.sales.dtos.sales.CreateSaleDTO;
import br.edu.ufop.web.ticket.sales.dtos.sales.SaleDTO;
import br.edu.ufop.web.ticket.sales.service.SaleService;
import br.edu.ufop.web.ticket.sales.service.clients.UserServiceClient;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/sales")
@AllArgsConstructor
public class SalesController {

    private final UserServiceClient userServiceClient;
    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAllSales() {
        return ResponseEntity.ok(saleService.getAll());
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Sales service is running.");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(
            userServiceClient.getAllUsers()
        );
    }

    @PostMapping
    public ResponseEntity<SaleDTO> create(@RequestBody CreateSaleDTO createSaleDTO) {
        SaleDTO saleDTO = saleService.create(createSaleDTO);

        if (saleDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(saleDTO);
    }
    
}
