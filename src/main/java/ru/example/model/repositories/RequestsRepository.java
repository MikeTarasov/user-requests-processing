package ru.example.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.model.entities.Requests;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Long> {
}