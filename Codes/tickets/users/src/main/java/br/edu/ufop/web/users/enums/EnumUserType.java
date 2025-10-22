package br.edu.ufop.web.users.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnumUserType {

    // Cliente - comprar ticket
    // Empresa - organização do eventos
    // Administrador
    CUSTOMER(1, "Customer"),
    ENTERPRISE(2, "Enterprise"),
    ADMIN(3, "Admin");

    



    private Integer id;
    private String description;
}
