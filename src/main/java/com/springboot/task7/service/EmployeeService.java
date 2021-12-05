package com.springboot.task7.service;

import com.springboot.task7.entity.Employee;
import com.springboot.task7.exception.EmployeeNotFoundException;
import com.springboot.task7.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        } else throw new EmployeeNotFoundException("Employee with id " + id + " not found!");
    }

    public Employee addNewEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee newEmployee, int id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.map(emp -> {
                    emp.setFirstName(newEmployee.getFirstName());
                    emp.setLastName(newEmployee.getLastName());
                    emp.setSalary(newEmployee.getSalary());
                    return employeeRepository.save(emp);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
        } else throw new EmployeeNotFoundException("Employee with id " + id + " not found!");

    }

    public void deleteEmployee(int id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            employeeRepository.delete(employee.get());
        } else throw new EmployeeNotFoundException("Employee with id " + id + " not found!");
    }
}
