package com.example.demo.Controller;
import com.example.demo.DemoApplication;
import com.example.demo.Dtos.SubjectDto;
import com.example.demo.services.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("admin")
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class SubjectAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;
    @DirtiesContext
    @Transactional
    @Test
    void createNewSubject() throws Exception {
        SubjectDto newSubject = new SubjectDto("Geography");

        mockMvc.perform(post("/api/admin/subject")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newSubject)))
                .andExpect(status().isOk());
        verify(adminService,times(1)).createNewSubject(Mockito.any());
    }
    @DirtiesContext
    @Transactional
    @Test
    void editSubject() throws Exception {
        SubjectDto editedSubject = new SubjectDto("Physics");

        mockMvc.perform(put("/api/admin/subject/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(editedSubject)))
                .andExpect(status().isOk());

        verify(adminService,times(1)).editSubject(Mockito.anyInt(), Mockito.any());
    }
    @DirtiesContext
    @Transactional
    @Test
    public void deleteSubject() throws Exception {
        SubjectDto subjectToDelete = new SubjectDto("Chemistry");

        mockMvc.perform(delete("/api/admin/subject/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(subjectToDelete)))
                .andExpect(status().isOk());

        verify(adminService,times(1)).deleteSubject(Mockito.anyInt());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DirtiesContext
    @Transactional
    @Test
    public void findAll() throws Exception {
        List<SubjectDto> subjects = new ArrayList<>();
        subjects.add(new SubjectDto("Mathematics"));
        subjects.add(new SubjectDto("History"));

        when(adminService.findAll()).thenReturn(subjects);

        mockMvc.perform(get("/api/admin/subject/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Mathematics"))
                .andExpect(jsonPath("$[1].name").value("History"));

        verify(adminService,times(1)).findAll();
    }
}