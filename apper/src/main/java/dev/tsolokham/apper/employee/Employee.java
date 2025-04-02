package dev.tsolokham.apper.employee;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

// employees: Name, Address (Street,
//City, Province), Telephone, Date of Hire, Title, Salary,
// Skill, Date of Birth, and age
public record Employee(
        Integer employeeID,
        String fName,
        String lName,
        String streetAddress,
        String city,
        String province,
        String telephone,
        LocalDateTime hireDate,
        String title,
        BigDecimal salary,
        LocalDateTime birthDate,
        Integer age
) {
}
