package ru.example.api.responces;

import lombok.Data;
import ru.example.model.entities.User;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListUsersResponse {

    private List<UserResponse> users;

    public ListUsersResponse(List<User> usersList) {
        users = new ArrayList<>(usersList.size());
        usersList.forEach(user -> users.add(new UserResponse(user)));
    }
}