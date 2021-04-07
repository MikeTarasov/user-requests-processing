package ru.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
    /**
     * TODO:
     * Просмотреть список пользователей
     * Назначить права оператора
     */
    private final String USER = "ROLE_USER";
    private final String OPERATOR = "ROLE_OPERATOR";
    private final String ADMINISTRATOR = "ROLE_ADMINISTRATOR";

    @Secured(ADMINISTRATOR)
    public ResponseEntity<?> getUsersList() {
        return null;
    }

    @Secured(ADMINISTRATOR)
    public ResponseEntity<?> grantOperatorAccess() {
        return null;
    }

    public ResponseEntity<?> login() {
        return null;
    }

    public ResponseEntity<?> logout() {
        return null;
    }
}
