package ru.example.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.example.api.requests.CreateRequest;
import ru.example.api.responces.ListRequestsResponse;
import ru.example.api.responces.MessageOkResponse;
import ru.example.api.responces.RequestResponse;
import ru.example.exceptions.CustomException;
import ru.example.exceptions.RequestNotFoundException;
import ru.example.exceptions.UnauthorizedException;
import ru.example.model.entities.Request;
import ru.example.model.entities.User;
import ru.example.model.enums.Status;
import ru.example.model.repositories.RequestsRepository;

import java.time.LocalDateTime;
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

    private Request findRequestById(long id) {
        Optional<Request> optionalRequest = requestsRepository.findById(id);
        if (!optionalRequest.isPresent()) {
            throw new RequestNotFoundException(id);
        }
        return optionalRequest.get();
    }

    private Request getRequest(long requestId) {
        User user = usersService.getCurrentUser();
        Request request = findRequestById(requestId);

        if (!request.getAuthor().equals(user)) {
            throw new UnauthorizedException();
        }
        return request;
    }

    public ResponseEntity<?> getUserRequest(long requestId) {
        return ResponseEntity.status(200).body(new RequestResponse(getRequest(requestId)));
    }

    public ResponseEntity<?> getUserRequests() {
        User user = usersService.getCurrentUser();
        List<Request> requests = requestsRepository.findByAuthor(user);
        return ResponseEntity.status(200).body(new ListRequestsResponse(requests));
    }

    public ResponseEntity<?> createRequest(CreateRequest requestBody) {
        User user = usersService.getCurrentUser();
        Request request = new Request(requestBody, user);
        requestsRepository.saveAndFlush(request);
        return ResponseEntity.status(200).body(new MessageOkResponse());
    }

    public ResponseEntity<?> editRequest(CreateRequest requestBody, long requestId) {
        Request request = getRequest(requestId);
        request.setText(requestBody.getText());
        request.setStatus(requestBody.getStatus());
        request.setDate(LocalDateTime.now());
        requestsRepository.saveAndFlush(request);
        return ResponseEntity.status(200).body(new MessageOkResponse());
    }

    public ResponseEntity<?> getListSubmittedRequests(int offset, int limit) {
        List<Request> requests = requestsRepository
                .findRequestsByStatusEquals(Status.DRAFT.toString(),
                        PageRequest.of(offset / limit, limit, Sort.by(Sort.Direction.DESC, "date")));

        return ResponseEntity.status(200).body(new ListRequestsResponse(requests));
    }

    public ResponseEntity<?> sendRequestForConsideration(long requestId) {
        changeRequestStatus(requestId, Status.DRAFT.toString(), Status.SHIPPED.toString(), false);
        return ResponseEntity.status(200).body(new MessageOkResponse());
    }

    public ResponseEntity<?> acceptRequest(long requestId) {
        changeRequestStatus(requestId, Status.SHIPPED.toString(), Status.ACCEPTED.toString(), true);
        return ResponseEntity.status(200).body(new MessageOkResponse());
    }

    public ResponseEntity<?> declineRequest(long requestId) {
        changeRequestStatus(requestId, Status.SHIPPED.toString(), Status.DECLINED.toString(), true);
        return ResponseEntity.status(200).body(new MessageOkResponse());
    }

    void changeRequestStatus(long requestId, String oldStatus, String newStatus, boolean isShipped) {
        Request request = getRequest(requestId);
        if (!request.getStatus().equalsIgnoreCase(oldStatus)) {
            throw new CustomException("Wrong status!");
        }
        request.setStatus(newStatus);
        if (isShipped) {
            request.setOperator(usersService.getCurrentUser());
        }
        requestsRepository.saveAndFlush(request);
    }
}