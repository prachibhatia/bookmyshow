package com.example.bookmyshow;

import com.example.bookmyshow.controllers.*;
import com.example.bookmyshow.dto.BookTicketRequestDto;
import com.example.bookmyshow.dto.BookTicketResponseDto;
import com.example.bookmyshow.models.SeatType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class BookmyshowApplication implements CommandLineRunner {

    private CityController cityController;
    private TheatreController theatreController;
    private MovieController movieController;
    private AuditoriumController auditoriumController;
    private SeatTypeController seatTypeController;
    private TicketController ticketController;

    public BookmyshowApplication(CityController cityController,
                                 TheatreController theatreController,
                                 MovieController movieController,
                                 AuditoriumController auditoriumController,
                                 TicketController ticketController,
                                 SeatTypeController seatTypeController){
        this.cityController = cityController;
        this.movieController = movieController;
        this.theatreController = theatreController;
        this.auditoriumController = auditoriumController;
        this.ticketController = ticketController;
        this.seatTypeController = seatTypeController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookmyshowApplication.class, args);
    }

    public void run(String args[]) throws Exception{
        cityController.addCity("Delhi");
        theatreController.createTheatre("PVR","Prashant Vihar",1L);
        theatreController.createTheatre("M2K","Rohini",1L);
        movieController.createMovie("Pathaan");
        movieController.createMovie("Don");
        auditoriumController.createAuditorium(1L,"Audi 1");
        auditoriumController.createAuditorium(1L,"Audi 2");
        HashMap<SeatType,Integer> map = new HashMap<>();
        map.put(seatTypeController.addSeatType("Gold"),20);
        map.put(seatTypeController.addSeatType("VIP"),20);
        map.put(seatTypeController.addSeatType("Platinum"),20);
        auditoriumController.createSeats(1L,map);
        auditoriumController.createShow(1L,1L,new Date(),new Date());

        BookTicketRequestDto requestDto = new BookTicketRequestDto();
        requestDto.setShowId(1L);
        List<Long> showSeats = new ArrayList<>();
        showSeats.add(1L);
        showSeats.add(4L);
        requestDto.setShowSeatIds(showSeats);

        BookTicketResponseDto response = ticketController.bookTicket(requestDto);
    }

}
