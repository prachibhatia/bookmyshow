package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType,Long> {
    @Override
    <S extends SeatType> S save(S entity);
}
