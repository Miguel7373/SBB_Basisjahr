package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class SchoolSubjectGradeDto{
    private int subject_id;
    private int grade_id;
    private String date;

    public SchoolSubjectGradeDto(int subjectId, int gradeId, String date) {
        subject_id = subjectId;
        grade_id = gradeId;
        this.date = date;
    }
}
