package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SchoolSubjectGradeOutDto extends Dto{
    private String name;
    private double grade;

    public SchoolSubjectGradeOutDto(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}
