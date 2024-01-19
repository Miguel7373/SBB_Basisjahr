package Dtos;

import java.util.Date;

public class SchoolSubjectGradeDto {
    private final int subject_id;
    private final int grade_id;
    private final String date;

    public SchoolSubjectGradeDto(int subjectId, int gradeId, String date) {
        subject_id = subjectId;
        grade_id = gradeId;
        this.date = date;
    }
}
