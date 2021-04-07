package ru.example.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.example.api.responces.ListUsersResponse;
import ru.example.api.responces.MessageOkResponse;
import ru.example.model.entities.User;
import ru.example.model.enums.Status;
import ru.example.model.repositories.UsersRepository;

import java.util.List;

@Service
public class AccountsService {

    private final UsersRepository usersRepository;
    private final ProcessingService processingService;

    public AccountsService(UsersRepository usersRepository, ProcessingService processingService) {
        this.usersRepository = usersRepository;
        this.processingService = processingService;
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
        processingService.changeRequestStatus(userId, Status.SHIPPED.toString(), Status.ACCEPTED.toString(), true);
        return ResponseEntity.status(200).body(new MessageOkResponse());
    }

    public ResponseEntity<?> revokeOperatorAccess(long userId) {
        processingService.changeRequestStatus(userId, Status.SHIPPED.toString(), Status.DECLINED.toString(), true);
        return ResponseEntity.status(200).body(new MessageOkResponse());
    }
}