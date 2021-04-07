package ru.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.example.api.requests.CreateRequest;
import ru.example.services.ProcessingService;

@RestController
@RequestMapping("/request")
public class ProcessingController {

    private final String USER = "ROLE_USER";
    private final String OPERATOR = "ROLE_OPERATOR";
    private final ProcessingService processingService;

    public ProcessingController(ProcessingService processingService) {
        this.processingService = processingService;
    }

    @Secured(USER)
    @GetMapping("/all")
    public ResponseEntity<?> getUserRequests() {
        return processingService.getUserRequests();
    }

    @Secured(USER)
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserRequest(@PathVariable("id") long requestId) {
        return processingService.getUserRequest(requestId);
    }

    @Secured(USER)
    @PostMapping("")
    public ResponseEntity<?> createRequest(@RequestBody CreateRequest requestBody) {
        return processingService.createRequest(requestBody);
    }

    @Secured(USER)
    @PutMapping("/{id}")
    public ResponseEntity<?> editRequest(@RequestBody CreateRequest requestBody, @PathVariable("id") long requestId) {
        return processingService.editRequest(requestBody, requestId);
    }

    @Secured(USER)
    @PostMapping("/send/{id}")
    public ResponseEntity<?> sendRequestForConsideration(@PathVariable("id") long requestId) {
        return processingService.sendRequestForConsideration(requestId);
    }


    @Secured(OPERATOR)
    @GetMapping("/submitted")
    public ResponseEntity<?> getListSubmittedRequests() {
        return processingService.getListSubmittedRequests();
    }

    @Secured(OPERATOR)
    @PostMapping("/submit/{id}")
    public ResponseEntity<?> acceptRequest(@PathVariable("id") long requestId) {
        return processingService.acceptRequest(requestId);
    }

    @Secured(OPERATOR)
    @PostMapping("/decline/{id}")
    public ResponseEntity<?> declineRequest(@PathVariable("id") long requestId) {
        return processingService.declineRequest(requestId);
    }
}