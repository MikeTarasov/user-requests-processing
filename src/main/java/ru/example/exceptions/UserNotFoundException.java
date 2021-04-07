package ru.example.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String email) {
        super("User with : " + email + " not found");
    }
}