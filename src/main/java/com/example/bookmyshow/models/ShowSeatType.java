package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@Entity
//This is the mapping table for show and seat
public class ShowSeatType extends BaseModel {
    @ManyToOne
    // 1:1
    // m:1
    private Show show;

    // SST:ST
    @ManyToOne
    // 1:1
    // m:1
    private SeatType seatType;
    private double price;
}
