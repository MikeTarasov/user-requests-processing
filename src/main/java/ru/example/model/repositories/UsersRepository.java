package ru.example.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.model.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
