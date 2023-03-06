package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel {
    // S:A
    @ManyToOne
    private Auditorium auditorium;
    private Date startTime;
    private Date endTime;

    // Show:Movie
    // 1 show belongs to 1 movie
    // 1 movie can run in many shows
    // m shows:1 movie
    @ManyToOne
    private Movie movie;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

}
