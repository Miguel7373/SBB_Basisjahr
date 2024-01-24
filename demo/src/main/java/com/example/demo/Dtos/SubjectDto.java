package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubjectDto {

    private String name;

    public SubjectDto(String name) {
        this.name = name;
    }
}
