package com.springboot.task7;

import com.springboot.task7.entity.Employee;
import com.springboot.task7.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee("Ivan","Batman",2500);
    }

    @AfterEach
    public void tearDown() {
        employeeRepository.deleteAll();
        employee = null;
    }

    @Test
    public void givenEmployeeToAddShouldReturnAddedEmployee(){
        employeeRepository.save(employee);
        Employee fetchedEmployee = employeeRepository.findById(employee.getId()).get();
        assertEquals(8, fetchedEmployee.getId());
    }

    @Test
    public void GivenGetAllEmployeeShouldReturnListOfAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        assertEquals("Andrew", employeeList.get(0).getFirstName());
        assertEquals("Alexandria", employeeList.get(1).getFirstName());
        assertEquals("Charles", employeeList.get(2).getFirstName());
        assertEquals("Wendy", employeeList.get(3).getFirstName());
        assertEquals("Jacob", employeeList.get(4).getFirstName());
    }

    @Test
    public void givenIdThenShouldReturnEmployeeOfThatId() {
        employeeRepository.save(employee);

        Optional<Employee> optional = employeeRepository.findById(employee.getId());
        assertEquals(employee.getId(), optional.get().getId());
        assertEquals(employee.getFirstName(), optional.get().getFirstName());
    }

    @Test
    public void givenDeleteThenShouldDeleteTheEmployee() {
        employeeRepository.save(employee);
        employeeRepository.deleteById(employee.getId());
        Optional<Employee> optional = employeeRepository.findById(employee.getId());
        assertEquals(Optional.empty(), optional);
    }
}
