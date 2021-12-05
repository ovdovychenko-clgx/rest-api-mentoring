package com.springboot.task7;

import com.springboot.task7.entity.Employee;
import com.springboot.task7.repository.EmployeeRepository;
import com.springboot.task7.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Autowired
    @InjectMocks
    private EmployeeService employeeService;
    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee("Oleh","Ivanenko", 3500.20);
    }

    @AfterEach
    public void tearDown() {
        employee = null;
    }

    @Test
    void givenEmployeeToAddShouldReturnAddedEmployee(){
        when(employeeRepository.save(any())).thenReturn(employee);
        employeeService.addNewEmployee(employee);
        verify(employeeRepository,times(1)).save(any());
    }

    @Test
    public void GivenGetAllUsersShouldReturnListOfAllUsers(){
        List<Employee> employeeList = List.of(employee);
        employeeRepository.save(employee);
        when(employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> actual = employeeService.getAllEmployee();
        assertEquals(employeeList,actual);
        verify(employeeRepository,times(1)).save(employee);
        verify(employeeRepository,times(1)).findAll();
    }

    @Test
    public void givenIdThenShouldReturnProductOfThatId() {
        when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(employee));
        assertThat(employeeService.getEmployeeById(employee.getId())).isEqualTo(employee);
    }

}
