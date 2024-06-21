package com.example.demo.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class newOutDto  extends SubjectCountDto{

    private List<GradeDateDto> GradeDateList;

    public newOutDto(String name,int subject_id, List<GradeDateDto> GradeDateList) {
        super(name, subject_id);
        this.GradeDateList = GradeDateList;
    }

    public newOutDto(List<GradeDateDto> GradeDateList) {
        this.GradeDateList = GradeDateList;
    }
}