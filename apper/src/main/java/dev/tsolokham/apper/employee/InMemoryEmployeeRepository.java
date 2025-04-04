package dev.tsolokham.apper.employee;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {

    private static final Logger log = LoggerFactory.getLogger(InMemoryEmployeeRepository.class);
    private final List<Employee> employees = new ArrayList<>();



    public List<Employee> findAll() {
        return employees;
    }


    public Optional<Employee> findById(Integer employeeID) {
        return Optional.ofNullable(employees.stream().filter(employee -> employee.employeeID() == employeeID)
                .findFirst().orElseThrow(EmployeeNotFoundException::new));
    }


    public void create(Employee employee) {
        Employee newEmployee = new Employee(employee.employeeID(),
                employee.fName(), employee.lName(), employee.streetAddress(),
                employee.city(), employee.lName(), employee.telephone(),
                employee.hireDate(), employee.title(), employee.salary(),
                employee.birthDate(), employee.age());

        employees.add(newEmployee);
    }


    public void update(Employee employee, Integer employeeID) {
        Optional<Employee> existingEmployee = findById(employeeID);
        if (existingEmployee.isPresent()) {
            var rec = existingEmployee.get();
            log.info("Updating Existing Client: {}", rec);
        }
    }


    public void delete(Integer employeeID) {
        log.info("Deleting Employee: {}", employeeID);
        employees.removeIf(employee -> employee.employeeID().equals(employeeID));
    }


    public int totalEmployees() {
        return employees.size();
    }


    public void saveAll(List<Employee> employees) {
        employees.forEach(this::create);
    }

    @PostConstruct
    private void init(){
        employees.add(new Employee(
                1, "Tsolo", "Khambule",
                "1010 Tintlock", "Pretoria", "Gauteng",
                "07211155555", LocalDateTime.parse("2021-10-21"),
                "Mr", BigDecimal.valueOf(200.00), LocalDateTime.parse("2003-10-21"),
                22
        ));

        employees.add(new Employee(
                2, "Milk", "Honey",
                "1010 Tintlock", "Pretoria", "Gauteng",
                "07211155455", LocalDateTime.parse("2021-10-21"),
                "Mr", BigDecimal.valueOf(1200.00), LocalDateTime.parse("2000-10-21"),
                25
        ));
    }
}
