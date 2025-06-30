package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
// import org.springframework.validation.annotation.Validated;

import com.example.demo.models.Employee;

@Repository
public class EmployeeRepo {
  
  @Autowired
  JdbcClient jdbcClient;



  public void create(Employee employee) {
    var updated = jdbcClient.sql("INSERT INTO employees ( first_name, last_name, email, phone_number, department, position, salary) VALUES (?, ?, ?, ?, ?, ?, ?);")
    .params(
      List.of(
      employee.firstName(),
      employee.lastName(),
      employee.email(),
      employee.phoneNumber(),
      employee.department(),
      employee.position(),
      employee.salary()
    )
    ).update();
    Assert.state(updated == 1, "Failed to insert employee record");
  }

  public void update(Employee employee, Integer id) {
    var updated = jdbcClient.sql("UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, department = ?, position = ?, salary = ? WHERE id = ?")
    .params(
      List.of(
      // Assuming id is auto-generated
       // or employee.id() if you want to use a specific ID
      employee.firstName(),
      employee.lastName(),
      employee.email(),
      employee.phoneNumber(),
      employee.department(),
      employee.position(),
      employee.salary(),
      employee.id()
    )
    ).update();

    Assert.state(updated == 1, "Failed to update employee record");
  }

  public void delete(Integer id) {
    var updated = jdbcClient.sql("DELETE FROM employees WHERE id = ?")
    .param(id).update();
    Assert.state(updated == 1, "Failed to delete employee record");
  }

  public List<Employee> getAllEmployees() {
    String sql = "SELECT * FROM employees";
    return jdbcClient.sql(sql)
      .query(Employee.class)
      .list();
  }

  public Optional<Employee> getEmployeeById(Integer id) {
    String sql = "SELECT * FROM employees WHERE id = ?";
    return jdbcClient.sql(sql)
      .param(id)
      .query(Employee.class).optional();
  }

  public int getEmployeeCount() {
    return jdbcClient.sql("SELECT COUNT(*) FROM employees")
      .query().listOfRows().size();
  }
  
}
