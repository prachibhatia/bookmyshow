package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {

    // S: ST
    // 1 seat can be of 1 seat type
    // but 1 seat type can belong to many seats
    @ManyToOne
    private SeatType seatType;
    private String name;
    private int row;
    private int col;
}
