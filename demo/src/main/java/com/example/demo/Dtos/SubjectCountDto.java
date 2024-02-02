package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class SubjectCountDto {
    private String name;
    private int subject_id;

    public SubjectCountDto(String name, int subject_id) {
        this.name = name;
        this.subject_id = subject_id;

    }
}
