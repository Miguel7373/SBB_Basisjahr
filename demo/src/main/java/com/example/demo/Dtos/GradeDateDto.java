package com.example.demo.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeDateDto {
     String date;
     Double grade;

    public GradeDateDto(String date, Double grade) {
        this.date = date;
        this.grade = grade;
    }

}
