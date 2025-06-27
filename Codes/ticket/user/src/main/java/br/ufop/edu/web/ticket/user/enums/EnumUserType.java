package br.ufop.edu.web.ticket.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumUserType {

    // Cliente - comprar ticket
    // Organizadora - evento
    // Administrador
    CUSTOMER(1, "Customer"),
    ENTERPRISE(2, "Enterprise"),
    ADMINISTRATOR(3, "Administrator"); 

    // id - descrição
    private Integer id;
    private String description;
    
}