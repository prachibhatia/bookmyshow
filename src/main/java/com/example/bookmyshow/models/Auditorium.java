package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel {
    private String name;
    // Audi:Show
    // 1:m
    // 1:1 (1 show belongs to 1 audi)
    @OneToMany(mappedBy = "auditorium")
    //because this same relation is represented in Show class also , so to avoid redundancy in schema we specify mappedBy so that
    //database don't consider this relation twice
    private List<Show> shows;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

    // Audi:Seat
    @OneToMany
    private List<Seat> seats;
}
