package com.example.bookmyshow.controllers;

import com.example.bookmyshow.models.Auditorium;
import com.example.bookmyshow.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
