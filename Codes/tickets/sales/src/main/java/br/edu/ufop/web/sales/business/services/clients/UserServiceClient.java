package br.edu.ufop.web.sales.business.services.clients;

import br.edu.ufop.web.sales.business.services.clients.dtos.UserServiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient("users-service")
public interface UserServiceClient {

    @GetMapping("/users")
    public List<UserServiceDTO> getAllUsers();

    @GetMapping("/users/{id}")
    public UserServiceDTO getById(@PathVariable(value = "id") UUID id);











}
