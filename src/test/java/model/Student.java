package model;

import org.example.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class Student {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllStudentsReturnsListOfStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    void updateStudentReturnsUpdatedStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/students/1")
                .contentType("application/json")
                .content("{\"name\": \"Updated Name\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Updated Name"));
    }

    @Test
    void updateStudentNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/students/999")
                .contentType("application/json")
                .content("{\"name\": \"Updated Name\"}"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void deleteStudentReturnsNoContent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/students/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteStudentNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/students/999"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}