package com.example.demo.interfaces;

import com.example.demo.Dtos.SubjectDto;

import java.util.List;

public interface AdminServiceInterface {
    void createNewSubject(SubjectDto newSubject);
    void editSubject(int i);
    List<SubjectDto> findAll();
    void deleteSubject(int i);
}
