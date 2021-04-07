package ru.example.api.responces;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class MessageOkResponse {

    private String message;
    private long time;

    public MessageOkResponse() {
        this.message = "ok";
        this.time = System.currentTimeMillis();
    }
}