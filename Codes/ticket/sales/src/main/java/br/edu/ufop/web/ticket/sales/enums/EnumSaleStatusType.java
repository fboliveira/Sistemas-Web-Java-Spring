package br.edu.ufop.web.ticket.sales.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumSaleStatusType {
    EM_ABERTO(0, "Aberto"),
    PAGO(1, "Pago"),
    CANCELADO(2, "Cancelado"),
    ESTORNADO(3, "Estornado");

    private Integer id;
    private String description;
}
