package ru.example.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.model.entities.Request;
import ru.example.model.entities.User;

import java.util.List;

@Repository
public interface RequestsRepository extends JpaRepository<Request, Long> {

    List<Request> findByAuthor(User author);
}