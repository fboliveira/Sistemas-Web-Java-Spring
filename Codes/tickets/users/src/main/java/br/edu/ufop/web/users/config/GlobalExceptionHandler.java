package br.edu.ufop.web.users.config;

import br.edu.ufop.web.users.exception.UseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UseCaseException.class)
    public ResponseEntity<String> handleUseCaseException(UseCaseException useCaseException) {
        return new ResponseEntity<>("[" + useCaseException.getClass().getSimpleName() + "] Erro na validação - " + useCaseException.getMessage(), HttpStatus.BAD_REQUEST);
    }













}
