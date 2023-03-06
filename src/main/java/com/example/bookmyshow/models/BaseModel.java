package com.example.bookmyshow.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass //Tells all the attributes of this class should be present in all child classes
public class BaseModel {
    @Id //shows this will be primary key in all tables
    private Long id;
}
