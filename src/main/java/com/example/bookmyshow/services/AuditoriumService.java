package com.example.bookmyshow.services;

import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuditoriumService {
    private AuditoriumRepository auditoriumRepository;
    private TheatreRepository theatreRepository;
    private MovieRepository movieRepository;
    private ShowRepository showRepository;
    private SeatRepository seatRepository;
    @Autowired
    public AuditoriumService(AuditoriumRepository auditoriumRepository,
                             TheatreRepository theatreRepository,
                             MovieRepository movieRepository,
                             ShowRepository showRepository,
                             SeatRepository seatRepository){
        this.auditoriumRepository = auditoriumRepository;
        this.theatreRepository = theatreRepository;
        this.movieRepository = movieRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
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

    public void addSeats(Long audiId, HashMap<SeatType,Integer> seatCount){
        Optional<Auditorium> optionalAuditorium = auditoriumRepository.findById(audiId);
        Auditorium auditorium = optionalAuditorium.get();
        if(auditorium.getSeats()==null){
            auditorium.setSeats(new ArrayList<>());
        }
        List<Seat> seats = new ArrayList<>();

        for (Map.Entry<SeatType, Integer> entry : seatCount.entrySet()) {
            for (int i = 0; i < entry.getValue(); ++i) {
                Seat seat = new Seat();
                seat.setSeatType(entry.getKey());
                // VIP1 VIP2 VIP3
                // PREMIUM1 PREMIUM2 PREMIUM3
                seat.setName(entry.getKey().toString() + Integer.toString(i + 1));
                seats.add(seat);
            }
        }

        List<Seat> savedSeats = seatRepository.saveAll(seats);
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);
    }

    public Show addShow(Long audiId, Long movieId, Date startTime , Date endTime ){
        Show show = new Show();
        show.setStartTime(startTime);
        show.setEndTime(endTime);
        Optional<Movie> OptionalMovie = movieRepository.findById(movieId);
        Movie movie = OptionalMovie.get();

        show.setMovie(movie);
        Show savedShow = showRepository.save(show);
        Optional<Auditorium> optionalAuditorium = auditoriumRepository.findById(audiId);

        Auditorium auditorium = optionalAuditorium.get();
        if(auditorium.getShows()==null){
            auditorium.setShows(new ArrayList<>());
        }
        auditorium.getShows().add(savedShow);
        auditoriumRepository.save(auditorium);
        return savedShow;
    }
}
