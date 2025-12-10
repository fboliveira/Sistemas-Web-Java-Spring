package br.edu.ufop.web.sales.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumEventType {

    PALESTRA(1, "Palestra"),
    SHOW(2, "Show"),
    TEATRO(3, "Teatro"),
    CURSO(4, "Curso"),
    GERAL(5, "Geral/não especificado");

    private Integer id;
    private String description;

    public static EnumEventType getById(Integer id) {

        for(EnumEventType type : EnumEventType.values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }

        return null;

    }

}
