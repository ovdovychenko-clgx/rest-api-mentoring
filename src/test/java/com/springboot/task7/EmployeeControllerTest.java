package com.springboot.task7;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.task7.controller.EmployeeController;
import com.springboot.task7.entity.Employee;
import com.springboot.task7.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;
    private Employee employee;
    private List<Employee> employeeList;

    @InjectMocks
    private EmployeeController employeeController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        Employee employee = new Employee("Ronin","Ball",670);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @AfterEach
    void tearDown() {
        employee = null;
    }

    @Test
    public void GetMappingOfAllEmployees() throws Exception {
        when(employeeService.getAllEmployee()).thenReturn(employeeList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees").
                contentType(MediaType.APPLICATION_JSON)).
            andExpect(status().isOk());
        verify(employeeService).getAllEmployee();
        verify(employeeService,times(1)).getAllEmployee();
    }
}
