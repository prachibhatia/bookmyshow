package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    @ManyToOne
    private Show show;

    // T:P
    // 1:m
    //  1 :1
    @OneToMany
    private List<Payment> payments;
    private double amount;

    // T: SS
    // 1: m
    // m : 1
    // because of cancellation 1 show seat can belong to many tickets too
    @ManyToMany
    private List<ShowSeat> showSeats;
    private Date bookingTime;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

//    public Ticket(Show show, List<Payment> payments, double amount, .. ) {
//        this.show = show;
//    }
}
