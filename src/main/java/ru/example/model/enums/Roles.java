package ru.example.model.enums;

public enum Roles {
    USER("ROLE_USER"),
    OPERATOR("ROLE_OPERATOR"),
    ADMINISTRATOR("ROLE_ADMINISTRATOR");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}