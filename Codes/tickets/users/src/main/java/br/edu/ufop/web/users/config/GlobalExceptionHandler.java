package br.edu.ufop.web.users.config;

import br.edu.ufop.web.users.exception.CCNetworkNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CCNetworkNotFoundException.class)
    public ResponseEntity<String> handleCCNetworkNotFoundException(CCNetworkNotFoundException exception) {
        return new ResponseEntity<>("[" + exception.getClass().getSimpleName() + "] " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
