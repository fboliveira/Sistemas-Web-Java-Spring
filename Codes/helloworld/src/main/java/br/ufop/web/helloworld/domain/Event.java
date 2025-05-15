package br.ufop.web.helloworld.domain;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter()
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Setter
    private Integer id;
    private UUID uuid;

    private String name;
    private String description;

    private LocalDateTime date;
    private OffsetDateTime closeDate;

    public Event example() {

        return Event.builder()
            .uuid(UUID.randomUUID())
            .build();

   }
}
