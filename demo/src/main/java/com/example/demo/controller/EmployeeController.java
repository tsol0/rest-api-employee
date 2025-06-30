package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.models.Employee;
import com.example.demo.repo.EmployeeRepo;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    // Endpoint to create a new employee
    // @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        employeeRepo.create(employee);
    }

    // Endpoint to update an existing employee
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer id,@RequestBody Employee employee) {
        employeeRepo.update(employee, id);
    }

    // Endpoint to delete an employee 
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeRepo.delete(id);
    }

    // Endpoint to get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }

}
