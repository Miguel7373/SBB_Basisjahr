package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SchoolSubjectGradeOutDto {
    private String name;
    private double grade;
    private String date;

    public SchoolSubjectGradeOutDto(String name, double grade, String date) {
        this.name = name;
        this.grade = grade;
        this.date = date;
    }
}
