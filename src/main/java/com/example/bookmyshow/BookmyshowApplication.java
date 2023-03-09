package com.example.bookmyshow;

import com.example.bookmyshow.controllers.CityController;
import com.example.bookmyshow.controllers.MovieController;
import com.example.bookmyshow.controllers.TheatreController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookmyshowApplication implements CommandLineRunner {

    private CityController cityController;
    private TheatreController theatreController;
    private MovieController movieController;

    public BookmyshowApplication(CityController cityController,
                                 TheatreController theatreController,
                                 MovieController movieController){
        this.cityController = cityController;
        this.movieController = movieController;
        this.theatreController = theatreController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookmyshowApplication.class, args);
    }

    public void run(String args[]) throws Exception{
        cityController.addCity("Delhi");
        theatreController.createTheatre("PVR","Prashant Vihar",1L);
    }

}
