package com.example.bookmyshow.controllers;

import com.example.bookmyshow.models.Auditorium;
import com.example.bookmyshow.models.SeatType;
import com.example.bookmyshow.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.HashMap;

@Controller
public class AuditoriumController {
    private AuditoriumService auditoriumService;

    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService){
        this.auditoriumService = auditoriumService;
    }

    public Auditorium createAuditorium(Long theatreId,String name){
        return auditoriumService.createAuditorium(theatreId,name);
    }
    public void createSeats(Long audiId, HashMap<SeatType,Integer> seatCount){
        auditoriumService.addSeats(audiId,seatCount);
    }
    public void createShow(Long audiId, Long movieId, Date startTime , Date endTime ){
        auditoriumService.addShow(audiId,movieId,startTime,endTime);
    }
}
