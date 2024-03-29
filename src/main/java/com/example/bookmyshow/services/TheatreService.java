package com.example.bookmyshow.services;

import com.example.bookmyshow.models.City;
import com.example.bookmyshow.models.Theatre;
import com.example.bookmyshow.repositories.CityRepository;
import com.example.bookmyshow.repositories.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TheatreService {
    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;

    public TheatreService(TheatreRepository theatreRepository,CityRepository cityRepository){
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
    }

    public Theatre createTheatre(String name,String address,Long cityId){

        Theatre theatre = new Theatre();
        theatre.setAddress(address);
        theatre.setName(name);
        theatre.setCompany(name);
        Theatre savedTheatre = theatreRepository.save(theatre);

        Optional<City> city = cityRepository.findById(cityId);


        City dbCity = city.get();
        if (dbCity.getTheatres() == null) {
            dbCity.setTheatres(new ArrayList<>());
        }
        dbCity.getTheatres().add(savedTheatre);
        this.cityRepository.save(dbCity);
        return savedTheatre;
    }
}
