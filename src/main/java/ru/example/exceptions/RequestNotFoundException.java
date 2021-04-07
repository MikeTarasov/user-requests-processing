package ru.example.exceptions;

public class RequestNotFoundException extends RuntimeException {

    public RequestNotFoundException(long id) {
        super("Request id= " + id + " not found!");
    }
}