package ru.example.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice()
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<?> handleUserNotFoundException() {
        return ResponseEntity.status(401).body(null);
    }

    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<?> handleUnauthorizedException() {
        return ResponseEntity.status(401).body(null);
    }

    @ExceptionHandler(RequestNotFoundException.class)
    protected ResponseEntity<?> handleRequestNotFoundException() {
        return ResponseEntity.status(400).body(null);
    }
}