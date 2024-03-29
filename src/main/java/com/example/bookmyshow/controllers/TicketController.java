package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dto.BookTicketRequestDto;
import com.example.bookmyshow.dto.BookTicketResponseDto;
import com.example.bookmyshow.models.Ticket;
import com.example.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {
        Long showId = request.getShowId();;
        List<Long> showSeatIds = request.getShowSeatIds();

        try {
            Ticket ticket = ticketService.bookTicket(
                    showId,
                    showSeatIds
            );

            BookTicketResponseDto response = new BookTicketResponseDto();
            response.setStatus("SUCCESS");
            response.setTicket(ticket);

            return response;
        } catch (Exception exception) {
            BookTicketResponseDto response = new BookTicketResponseDto();
            response.setStatus("FAILURE");

            return response;
        }
    }
}
