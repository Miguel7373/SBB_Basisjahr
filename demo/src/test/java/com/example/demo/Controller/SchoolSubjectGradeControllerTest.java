package com.example.demo.Controller;

import com.example.demo.Dtos.AvgGradeDto;
import com.example.demo.Dtos.Dto;
import com.example.demo.Dtos.SchoolSubjectGradeOutDto;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class SchoolSubjectGradeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @DirtiesContext
    @Transactional
    @Test
    void createNewGrade() throws Exception {
        mockMvc.perform(post("/api/student/school_subject_grade/grade")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"grade\": 90.5, \"subject\": \"Math\"}"))
                .andExpect(status().isOk());

        verify(userService,times(1)).createNewGrade(Mockito.any());
    }

    @DirtiesContext
    @Transactional
    @Test
    void editGrade() throws Exception {
        mockMvc.perform(put("/api/student/school_subject_grade/grade/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"grade\": 95.0, \"subject\": \"History\"}"))
                .andExpect(status().isOk());

        verify(userService,times(1)).editGrade(Mockito.anyInt(), Mockito.any());
    }

    @DirtiesContext
    @Transactional
    @Test
    void deleteGrade() throws Exception {
        mockMvc.perform(delete("/api/student/school_subject_grade/grade/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService,times(1)).deleteGrade(Mockito.anyInt());
    }

    @DirtiesContext
    @Transactional
    @Test
    void findAll() throws Exception {
        List<SchoolSubjectGradeOutDto> grades = new ArrayList<>();
        grades.add(new SchoolSubjectGradeOutDto("Math", 90.5));
        grades.add(new SchoolSubjectGradeOutDto("History", 95.0));

        when(userService.findAll()).thenReturn(grades);

        mockMvc.perform(get("/api/student/school_subject_grade")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Math"))
                .andExpect(jsonPath("$[0].grade").value(90.5))
                .andExpect(jsonPath("$[1].name").value("History"))
                .andExpect(jsonPath("$[1].grade").value(95.0));

        verify(userService,times(1)).findAll();
    }

    @DirtiesContext
    @Transactional
    @Test
    void findAllAvg() throws Exception {
        List<AvgGradeDto> avgGrades = new ArrayList<>();
        avgGrades.add(new AvgGradeDto("Math", 6));
        avgGrades.add(new AvgGradeDto("History", 4));

        when(userService.findAllAvg()).thenReturn(avgGrades);

        mockMvc.perform(get("/api/student/school_subject_grade/average")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Math"))
                .andExpect(jsonPath("$[0].avg").value(6.0))
                .andExpect(jsonPath("$[1].name").value("History"))
                .andExpect(jsonPath("$[1].avg").value(4.0));

        verify(userService,times(1)).findAllAvg();
    }

    @DirtiesContext
    @Transactional
    @Test
    void findById() throws Exception {
        List<Dto> subjects = new ArrayList<>();
        subjects.add(new SchoolSubjectGradeOutDto("Math", 1));
        subjects.add(new AvgGradeDto("Math", 6));
        when(userService.findById(1)).thenReturn(subjects);


        mockMvc.perform(get("/api/student/school_subject_grade/average/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].grade").value(1))
                .andExpect(jsonPath("$[0].name").value("Math"))
                .andExpect(jsonPath("$[1].avg").value(6))
                .andExpect(jsonPath("$[1].name").value("Math"));

        verify(userService,times(1)).findById(Mockito.anyInt());

    }

    @Test
    void getActiveProfiles() throws Exception {


        mockMvc.perform(get("/api/student/getActiveProfiles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(userService,times(1)).getActiveProfiles();
    }
}