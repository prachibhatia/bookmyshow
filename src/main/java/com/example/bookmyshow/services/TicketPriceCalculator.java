package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatType;
import com.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketPriceCalculator {
    private ShowSeatTypeRepository showSeatTypeRepository;

    @Autowired
    public TicketPriceCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculateTicketPrice(List<ShowSeat> showSeats) {
        Show show = showSeats.get(0).getShow();

        // 1. Get ShowSeatType objects for this show
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShowEquals(show);

        // 2. Add the prices and done
        double amount = 0;

        for (ShowSeat showSeat: showSeats) {
            for (ShowSeatType showSeatType: showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                }
            }
        }

        return amount;
    }
}