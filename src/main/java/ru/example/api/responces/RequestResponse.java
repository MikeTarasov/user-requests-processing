package ru.example.api.responces;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.example.model.entities.Request;


@Data
@AllArgsConstructor
public class RequestResponse {

    private String text;
    private String status;
    private long date;
    private String author;

    public RequestResponse(Request request) {
        this.text = request.getText();
        this.status = request.getStatus();
        this.date = request.getTimeStamp();
        this.author = String.join(" ", request.getAuthor().getName(), request.getAuthor().getSurname());
    }
}