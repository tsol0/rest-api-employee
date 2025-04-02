package dev.tsolokham.apper.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> findALl();

    Optional<Employee> findById(Integer employeeID);

    void create(Employee employee);
    void update(Employee employee, Integer employeeID);
    void delete(Integer employeeID);
    int totalEmployees();

    void saveAll(List<Employee> employees);

}
