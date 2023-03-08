package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long> {
    Theatre save(Theatre theatre);

    @Override
    Optional<Theatre> findById(Long theatreId);
}
