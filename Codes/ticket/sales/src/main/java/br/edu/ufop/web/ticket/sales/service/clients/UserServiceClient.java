package br.edu.ufop.web.ticket.sales.service.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ufop.web.ticket.sales.dtos.externals.UserDTO;

@FeignClient("users-service")
public interface UserServiceClient {
    
    @GetMapping("/users")
    List<UserDTO> getAllUsers();
}
