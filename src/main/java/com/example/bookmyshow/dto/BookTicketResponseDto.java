package com.example.bookmyshow.dto;

import com.example.bookmyshow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private String status;
    private Ticket ticket;
}