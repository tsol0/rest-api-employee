package dev.tsolokham.apper.employee;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final JdbcEmployeeRepository employeeRepo;

    EmployeeController(JdbcEmployeeRepository employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @GetMapping
    List<Employee> findAll (){
        return employeeRepo.findAll();
    }


    @GetMapping("/{id}")
    Employee findById(@PathVariable Integer employeeID){
        Optional<Employee> employee = employeeRepo.findById(employeeID);
        if (employee.isPresent()) return employee.get();
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found.");
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void create(@Valid @RequestBody Employee employee){
        employeeRepo.create(employee);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update (@Valid @RequestBody Employee employee, @PathVariable Integer employeeID){
        employeeRepo.update(employee, employeeID);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id")
    void delete(@PathVariable Integer employeeID){
        employeeRepo.delete(employeeID);
    }

}
