package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AvgGradeDto extends SubjectDto{

    private double avg;
    private int subjectId;

    public AvgGradeDto(String name, double avg, int subjectId) {
        super(name);
        this.avg = avg;
        this.subjectId = subjectId;
    }
}
