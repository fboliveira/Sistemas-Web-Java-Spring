package br.ufop.edu.web.ticket.user.domain.usecase;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UpdateUserPasswordUseCaseTest {
    
    @Test
    void validateEMailAndPasswordAreEqual() {

        String email = "test@tickets.com";
        String password = "123456";

        UpdateUserPasswordUseCase updateUserPasswordUseCase =
            new UpdateUserPasswordUseCase(email, email, password, password);

        Assertions.assertDoesNotThrow(() -> {
            updateUserPasswordUseCase.validate();
        });

    }

    @Test
    void validateEMailIsDifferent() {

        UpdateUserPasswordUseCase updateUserPasswordUseCase = 
            new UpdateUserPasswordUseCase(UUID.randomUUID().toString(), UUID.randomUUID().toString(), null, null);

        Assertions.assertThrows(RuntimeException.class, () -> {
            updateUserPasswordUseCase.validate();
        });

    }

    @Test
    void validateOldPasswordIsDifferent() {

        String email = UUID.randomUUID().toString();
        UpdateUserPasswordUseCase updateUserPasswordUseCase =
            new UpdateUserPasswordUseCase(email, email, UUID.randomUUID().toString(), UUID.randomUUID().toString());

        Assertions.assertThrows(RuntimeException.class, () -> {
            updateUserPasswordUseCase.validate();
        });

    }

}
