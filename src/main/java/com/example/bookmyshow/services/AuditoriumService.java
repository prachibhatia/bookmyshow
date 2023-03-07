package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Auditorium;
import com.example.bookmyshow.models.City;
import com.example.bookmyshow.models.Theatre;
import com.example.bookmyshow.repositories.AuditoriumRepository;
import com.example.bookmyshow.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuditoriumService {
    private AuditoriumRepository auditoriumRepository;
    private TheatreRepository theatreRepository;
    @Autowired
    public AuditoriumService(AuditoriumRepository auditoriumRepository,TheatreRepository theatreRepository){
        this.auditoriumRepository = auditoriumRepository;
        this.theatreRepository = theatreRepository;
    }
    public Auditorium createAuditorium(Long theatreId,String name){
        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        Auditorium savedAudi = auditoriumRepository.save(auditorium);
        Optional<Theatre> theatreOptional = theatreRepository.findById(theatreId);
        Theatre theatre = theatreOptional.get();
        if (theatre.getAuditoriums() == null) {
            theatre.setAuditoriums(new ArrayList<>());
        }
        theatre.getAuditoriums().add(savedAudi);
        theatreRepository.save(theatre);
        return savedAudi;
    }
}
