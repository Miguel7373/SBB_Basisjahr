package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SchoolSubjectGradeOutDto extends SubjectDto{

    private List<GradeDateDto> GradeDateList;

    public SchoolSubjectGradeOutDto(String name, List<GradeDateDto> GradeDateList) {
        super(name);
        this.GradeDateList = GradeDateList;
    }

    public SchoolSubjectGradeOutDto(List<GradeDateDto> GradeDateList) {
        this.GradeDateList = GradeDateList;
    }
}