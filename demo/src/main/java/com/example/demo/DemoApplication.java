package com.example.demo;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

// import com.example.demo.models.Employee;
// import com.example.demo.repo.EmployeeRepo;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private  Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Autowired
	// private EmployeeRepo employeeRepo;

	@Override
	public void run(String... args) throws Exception {

		logger.info("Starting the application...");
		// logger.info("Inserting employees...");
		// // create dummy employees
		// employeeRepo.create(new Employee(-1, "John", "Doe", "john@example.com", "1234567890", "Engineering", "Software Engineer", 60000.00));

		// employeeRepo.create(new Employee(-1,"Jane", "Smith", "jane@example.com", "0987654321", "Marketing", "Marketing Manager", 70000.00));

		// employeeRepo.create(new Employee(-1,"Alice", "Johnson", "alice@example.com", "1122334455", "Sales", "Sales Executive", 55000.00));

		// employeeRepo.create(new Employee(-1,"Bob", "Brown", "bobbie@example.com", "6677889900", "HR", "HR Specialist", 50000.00));

		// logger.info("Employees inserted successfully.");

		// logger.info("Retrieving all employees...");
		// employeeRepo.getAllEmployees();
		// logger.info("All employees retrieved successfully.");

		// logger.info("Updating employee with ID 1...");
		// employeeRepo.update(new Employee(1, "Thato", "Doe", "Thato@example.com", "1234567890", "Engineering", "Software Engineer", 60002.00), 1);
		// logger.info("Employee updated successfully.");

		// logger.info("Retrieving all employees after update...");
		// employeeRepo.getAllEmployees();
		// logger.info("All employees retrieved successfully after update.");


		
	}
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.ignoreIfMalformed()
				.ignoreIfMissing()
				.load();
		System.setProperty("DB_HOST", dotenv.get("DB_HOST"));
		System.setProperty("DB_PORT", dotenv.get("DB_PORT"));
		System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		// Start the Spring Boot application
		SpringApplication.run(DemoApplication.class, args);
	}

}
