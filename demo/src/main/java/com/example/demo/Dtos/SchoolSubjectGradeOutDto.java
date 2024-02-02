package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SchoolSubjectGradeOutDto extends SubjectDto{

    private List<Double> grade;

    public SchoolSubjectGradeOutDto(String name, List<Double> grade) {
        super(name);
        this.grade = grade;
    }

    public SchoolSubjectGradeOutDto(List<Double> grade) {
        this.grade = grade;
    }
}
