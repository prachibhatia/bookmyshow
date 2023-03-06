package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;

@Getter
@Setter
@Entity
public class Actor extends BaseModel {
    private String name;

}
