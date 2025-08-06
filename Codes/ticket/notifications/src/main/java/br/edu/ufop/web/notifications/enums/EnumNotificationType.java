package br.edu.ufop.web.notifications.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumNotificationType {
    
    MESSAGE(0, "Message"),
    EMAIL(1, "E-Mail"),
    WHATSAPP(2, "WhatsApp"),
    TELEGRAM(3, "Telegram");

    private Integer id;
    private String description;

}
