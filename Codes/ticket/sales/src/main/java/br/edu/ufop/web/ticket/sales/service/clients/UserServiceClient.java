package br.edu.ufop.web.ticket.sales.service.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ufop.web.ticket.sales.dtos.external.users.UserDTO;

@FeignClient("users-service")
public interface UserServiceClient {

    @GetMapping("/users")
    List<UserDTO> getAllUsers();
    
}
