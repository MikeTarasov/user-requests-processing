package ru.example.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.example.api.requests.CreateRequest;
import ru.example.model.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operator_id")
    private User operator;

    public Request(CreateRequest request, User author) {
        this.status = Status.DRAFT.toString();
        this.text = request.getText();
        date = LocalDateTime.now();
        this.author = author;
    }

    public long getTimeStamp() {
        return date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}