package com.example.bookmyshow.services;

import com.example.bookmyshow.models.SeatType;
import com.example.bookmyshow.repositories.SeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatTypeService {
    private SeatTypeRepository seatTypeRepository;
    @Autowired
    public SeatTypeService(SeatTypeRepository seatTypeRepository){
        this.seatTypeRepository = seatTypeRepository;
    }
    public SeatType addSeatType(String name){
        SeatType seatType = new SeatType();
        seatType.setName(name);
        return seatTypeRepository.save(seatType);
    }
}
