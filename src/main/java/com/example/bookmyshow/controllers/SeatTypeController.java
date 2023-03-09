package com.example.bookmyshow.controllers;

import com.example.bookmyshow.models.SeatType;
import com.example.bookmyshow.services.SeatTypeService;
import org.springframework.stereotype.Controller;

@Controller
public class SeatTypeController {
    private SeatTypeService seatTypeService;
    public SeatTypeController(SeatTypeService seatTypeService){
        this.seatTypeService = seatTypeService;
    }
    public SeatType addSeatType(String name){
        return seatTypeService.addSeatType(name);
    }
}
