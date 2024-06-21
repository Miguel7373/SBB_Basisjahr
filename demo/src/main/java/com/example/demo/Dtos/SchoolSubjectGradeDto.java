package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class SchoolSubjectGradeDto{
    private int grade_id;
    private int subject_id;
    private String date;
    private int user_id;

    public SchoolSubjectGradeDto(int grade_id, int subject_id, String date, int userId) {
        this.grade_id = grade_id;
        this.subject_id = subject_id;
        this.date = date;
        this.user_id = userId;
    }
}
