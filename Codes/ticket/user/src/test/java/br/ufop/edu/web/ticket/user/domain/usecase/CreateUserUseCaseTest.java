package br.ufop.edu.web.ticket.user.domain.usecase;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufop.edu.web.ticket.user.domain.UserDomain;

class CreateUserUseCaseTest {

    private UserDomain userDomain;

    @BeforeEach
    void setUp() {
        this.userDomain = new UserDomain();
        this.userDomain.setName(UUID.randomUUID().toString());
    }

    @AfterEach
    void cleanUp() {
        this.userDomain = null;
    }

    @Test
    void userNameNotNull() {

        Assertions.assertNotNull(this.userDomain);
        Assertions.assertNotNull(this.userDomain.getName());

        CreateUserUseCase createUserUseCase = new CreateUserUseCase(this.userDomain);

        Assertions.assertDoesNotThrow(() -> {
            createUserUseCase.validate();
        });

    }

    @Test
    void userNameIsNull() {

        this.userDomain.setName(null);

        CreateUserUseCase createUserUseCase = new CreateUserUseCase(this.userDomain);

        Assertions.assertThrows(RuntimeException.class, () -> {
            createUserUseCase.validate();
        });


    }
     
}
