package controller;

import org.example.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStudentByIdReturnsStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"));
    }

    @Test
    void getStudentByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students/999"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void createStudentReturnsCreatedStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/students")
                .contentType("application/json")
                .content("{\"name\": \"Jane Doe\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jane Doe"));
    }

    @Test
    void createStudentInvalidInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/students")
                .contentType("application/json")
                .content("{\"name\": \"\"}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}