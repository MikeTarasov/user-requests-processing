package ru.example.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.example.model.enums.Roles;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

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
    private List<Request> requests = new ArrayList<>();

    @OneToMany(mappedBy = "operator", fetch = FetchType.LAZY)
    private List<Request> moderatedRequests = new ArrayList<>();


    public boolean isUser() {
        return isUser == 1;
    }

    public boolean isOperator() {
        return isOperator == 1;
    }

    public boolean isAdministrator() {
        return isAdmin == 1;
    }

    public Set<GrantedAuthority> getGrantedAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (isUser()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(Roles.USER.getRole()));
        }
        if (isOperator()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(Roles.OPERATOR.getRole()));
        }
        if (isAdministrator()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(Roles.ADMINISTRATOR.getRole()));
        }
        return grantedAuthorities;
    }
}