package com.example.demo.interfaces;

import com.example.demo.Dtos.SubjectDto;

import java.util.List;

public interface AdminRepositoryInterface {
    void createNewSubject(SubjectDto newSubject);
    void editSubject(int subjectId, SubjectDto updatedSubject);
    List<SubjectDto> findAll();
    void deleteSubject(int i);
}
