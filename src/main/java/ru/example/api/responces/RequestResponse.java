package ru.example.api.responces;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.example.model.entities.Requests;


@Data
@AllArgsConstructor
public class RequestResponse {

    private String text;
    private String status;
    private long date;

    public RequestResponse(Requests request) {
        this.text = request.getText();
        this.status = request.getStatus();
        this.date = request.getTimeStamp();
    }
}