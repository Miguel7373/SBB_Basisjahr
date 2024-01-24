package com.example.demo.services;

import com.example.demo.Dtos.SubjectDto;
import com.example.demo.repository.AdminRepository;
import com.example.demo.interfaces.AdminServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements AdminServiceInterface {
    private final AdminRepository adminRepository;
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void createNewSubject(SubjectDto newSubject) {
        adminRepository.createNewSubject(newSubject);
    }

    public void editSubject(int i) {
        adminRepository.editSubject(2);

    }

    public List<SubjectDto> findAll() {
        return adminRepository.findAll();

    }

    public void deleteSubject(int i) {
        adminRepository.deleteSubject(1);

    }
}