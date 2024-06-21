package com.example.demo.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeDateDto {
     int ID;
     String date;
     Double grade;

    public GradeDateDto(int ID, String date, Double grade) {
        this.ID = ID;
        this.date = date;
        this.grade = grade;
    }

}
