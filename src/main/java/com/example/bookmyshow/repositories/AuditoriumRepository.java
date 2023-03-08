package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Long> {
    Auditorium save(Auditorium auditorium);

    @Override
    Optional<Auditorium> findById(Long aLong);
}
