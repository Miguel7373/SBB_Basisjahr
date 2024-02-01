package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AvgGradeDto extends Dto{
    private String name;
    private double avg;

    public AvgGradeDto(String name, double avg) {
        this.name = name;
        this.avg = avg;
    }
}
