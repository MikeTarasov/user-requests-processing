package ru.example.api.responces;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.example.model.entities.User;


@Data
@AllArgsConstructor
public class UserResponse {

    private long id;
    private String name;
    private String surname;
    private long regDate;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.regDate = user.getTimeStamp();
    }
}