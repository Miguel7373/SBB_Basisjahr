package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GradeDto {
    private int grade_Id;

    public GradeDto(int grade_Id) {
        this.grade_Id = grade_Id;
    }
}
