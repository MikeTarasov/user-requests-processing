package ru.example.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.example.api.requests.CreateRequest;

@Service
public class ProcessingService {

    public ResponseEntity<?> getUserRequest(long requestId) {
        return null;
    }

    public ResponseEntity<?> getUserRequests() {
        return null;
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