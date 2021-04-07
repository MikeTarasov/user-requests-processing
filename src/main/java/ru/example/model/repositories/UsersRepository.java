package ru.example.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.model.entities.User;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findUserById(long id);

    User findByEmail(String email);

    List<User> findUsersByIsUser(int isUser);

    List<User> findUsersByIsOperator(int isOperator);
}
