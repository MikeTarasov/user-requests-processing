package ru.example.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "reg_date", nullable = false)
    private LocalDateTime regDate;

    @Column(name = "is_user")
    private Integer isUser;

    @Column(name = "is_operator")
    private Integer isOperator;

    @Column(name = "is_admin")
    private Integer isAdmin;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Requests> requests = new ArrayList<>();

    @OneToMany(mappedBy = "operator", fetch = FetchType.LAZY)
    private List<Requests> moderatedRequests = new ArrayList<>();
}