package ru.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessingController {
    /**
     * TODO:
     * Создать заявку (Заявка помимо прочих системных полей состоит из статуса и текстового обращения пользователя)
     * Отправить заявку оператору на рассмотрение
     * Просмотреть список отправленных на рассмотрение заявок, отсортированных по дате создания
     * Посмотреть заявку
     * Принять заявку
     * Отклонить заявку
     */

    public ResponseEntity<?> createRequest() {
        return null;
    }

    public ResponseEntity<?> sendRequestForConsideration() {
        return null;
    }

    public ResponseEntity<?> getListSubmittedRequests() {
        return null;
    }

    public ResponseEntity<?> getRequest() {
        return null;
    }

    public ResponseEntity<?> acceptRequest() {
        return null;
    }

    public ResponseEntity<?> declineRequest() {
        return null;
    }
}