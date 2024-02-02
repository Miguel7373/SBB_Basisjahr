package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AvgGradeDto extends SubjectDto{

    private double avg;

    public AvgGradeDto(String name, double avg) {
        super(name);
        this.avg = avg;
    }
}
