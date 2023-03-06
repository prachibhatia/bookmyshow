package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    // SS : S
    // 1:1
    //  m:1
    @ManyToOne
    private Show show;

    // SS: S
    // 1 seat object can be associated to many show seats
    // so m:1
    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}
