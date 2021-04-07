package ru.example.exceptions;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super("Session is not authorized");
    }
}