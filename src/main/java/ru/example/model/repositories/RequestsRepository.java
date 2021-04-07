package ru.example.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.model.entities.Requests;
import ru.example.model.entities.Users;

import java.util.List;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Long> {

    List<Requests> findByAuthor(Users author);
}