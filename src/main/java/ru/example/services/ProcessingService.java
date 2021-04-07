package ru.example.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.example.api.requests.CreateRequest;
import ru.example.api.responces.ListRequestsResponse;
import ru.example.api.responces.RequestResponse;
import ru.example.exceptions.RequestNotFoundException;
import ru.example.exceptions.UnauthorizedException;
import ru.example.model.entities.Requests;
import ru.example.model.entities.Users;
import ru.example.model.repositories.RequestsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessingService {

    private final UsersService usersService;
    private final RequestsRepository requestsRepository;

    public ProcessingService(UsersService usersService, RequestsRepository requestsRepository) {
        this.usersService = usersService;
        this.requestsRepository = requestsRepository;
    }

    private Requests findRequestById(long id) {
        Optional<Requests> optionalRequest = requestsRepository.findById(id);
        if (!optionalRequest.isPresent()) {
            throw new RequestNotFoundException(id);
        }
        return optionalRequest.get();
    }

    public ResponseEntity<?> getUserRequest(long requestId) {
        Users user = usersService.getCurrentUser();
        Requests request = findRequestById(requestId);

        if (!request.getAuthor().equals(user)) {
            throw new UnauthorizedException();
        }
        return ResponseEntity.status(200).body(new RequestResponse(request));
    }

    public ResponseEntity<?> getUserRequests() {
        Users user = usersService.getCurrentUser();
        List<Requests> requests = requestsRepository.findByAuthor(user);
        return ResponseEntity.status(200).body(new ListRequestsResponse(requests));
    }

    public ResponseEntity<?> createRequest(CreateRequest requestBody) {
        return null;
    }

    public ResponseEntity<?> editRequest(CreateRequest requestBody, long requestId) {
        return null;
    }

    public ResponseEntity<?> sendRequestForConsideration(long requestId) {
        return null;
    }


    public ResponseEntity<?> getListSubmittedRequests() {
        return null;
    }

    public ResponseEntity<?> acceptRequest(long requestId) {
        return null;
    }

    public ResponseEntity<?> declineRequest(long requestId) {
        return null;
    }
}