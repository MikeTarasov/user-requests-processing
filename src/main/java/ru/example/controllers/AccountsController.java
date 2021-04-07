package ru.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.example.services.AccountsService;

@RestController
@RequestMapping("/users")
public class AccountsController {
    /**
     * TODO:
     * Просмотреть список пользователей
     * Назначить права оператора
     */
    private final String ADMINISTRATOR = "ROLE_ADMINISTRATOR";
    private final AccountsService accountsService;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @Secured(ADMINISTRATOR)
    @GetMapping("/users")
    public ResponseEntity<?> getUsersList() {
        return accountsService.getUsersList();
    }

    @Secured(ADMINISTRATOR)
    @GetMapping("/operators")
    public ResponseEntity<?> getOperatorsList() {
        return accountsService.getOperatorsList();
    }

    @Secured(ADMINISTRATOR)
    @PostMapping("/grant/{id}")
    public ResponseEntity<?> grantOperatorAccess(@PathVariable("id") long userId) {
        return accountsService.grantOperatorAccess(userId);
    }

    @Secured(ADMINISTRATOR)
    @PostMapping("/revoke/{id}")
    public ResponseEntity<?> revokeOperatorAccess(@PathVariable("id") long userId) {
        return accountsService.revokeOperatorAccess(userId);
    }

//    public ResponseEntity<?> login() {
//        return null;
//    }
//
//    public ResponseEntity<?> logout() {
//        return null;
//    }
}
