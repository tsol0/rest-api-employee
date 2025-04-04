package dev.tsolokham.apper.employee;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcEmployeeRepository implements  EmployeeRepository{
    private final JdbcClient jdbcClient;


    public JdbcEmployeeRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Employee> findAll(){
        return jdbcClient.sql("select * from employee")
                .query(Employee.class).list();
    }

    public Optional<Employee> findById(Integer employeeID){
        return jdbcClient.sql("select * from employee where employeeID" +
                "= :employeeID ").param("employeeID", employeeID)
                .query(Employee.class).optional();
    }

    public void create(Employee employee){
        var updated = jdbcClient.sql("insert into Employee(" +
                "employeeID,fName,lName, streetAddress, city, province," +
                " telephone, hireDate, title, salary, birthDate, age)" +
                        " values(?,?,?,?,?,?,?,?,?,?,?,?)")
                .params(
                        List.of(employee.employeeID(),employee.fName(),
                        employee.lName(), employee.streetAddress(), employee.city(),
                        employee.telephone(), employee.hireDate(), employee.title(),
                        employee.salary(), employee.birthDate(), employee.age()
                        )
                ).update();
        Assert.state(updated == 1, "Failed to create employee");
    }


    public void update(Employee employee, Integer employeeID){
        var updated = jdbcClient.sql("update run set fName = ?, lName = ?," +
                " streetAddress = ?, city = ?, province = ?, telephone = ?, hireDate= ?," +
                "title =?, salary= ?, birthDate = ?, age = ? where employeeID = ?")
                .params(List.of(employee.fName(), employee.lName(), employee.streetAddress(),
                        employee.streetAddress(), employee.city(), employee.telephone(),
                        employee.hireDate(), employee.title(), employee.salary(),
                        employee.birthDate(), employee.age()), employeeID).update();

        Assert.state(updated== 1, "Failed to update employee record");
    }


    public void delete(Integer employeeID){
        var updated = jdbcClient.sql("delete from run where id = :id")
                .param("employeeID", employeeID).update();

        Assert.state(updated == 1, "Failed to delete employee record");
    }


    public int totalEmployees() {
        return jdbcClient.sql("select * from employee").query().listOfRows().size();
    }


    public void saveAll(List<Employee> employees){
//        employees.stream().forEach(this::create);
        employees.forEach(this::create);
    }

}
