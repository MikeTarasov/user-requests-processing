package ru.example.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.example.api.responces.ListUsersResponse;
import ru.example.model.entities.User;
import ru.example.model.repositories.UsersRepository;

import java.util.List;

@Service
public class AccountsService {

    private final UsersRepository usersRepository;

    public AccountsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public ResponseEntity<?> getUsersList() {
        List<User> users = usersRepository.findUsersByIsUser(1);
        return ResponseEntity.status(200).body(new ListUsersResponse(users));
    }

    public ResponseEntity<?> getOperatorsList() {
        List<User> operators = usersRepository.findUsersByIsOperator(1);
        return ResponseEntity.status(200).body(new ListUsersResponse(operators));
    }

    public ResponseEntity<?> grantOperatorAccess(long userId) {
        return null;
    }

    public ResponseEntity<?> revokeOperatorAccess(long userId) {
        return null;
    }
}
