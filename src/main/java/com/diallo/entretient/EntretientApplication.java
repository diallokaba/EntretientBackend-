package com.diallo.entretient;

import com.diallo.entretient.entities.Employees;
import com.diallo.entretient.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntretientApplication implements CommandLineRunner {

    @Autowired
    private EmployeesRepository employeesRepository;

    public static void main(String[] args) {
        SpringApplication.run(EntretientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employees employees = new Employees();
        employees.setNom("diallo");
        employees.setPrenom("ibrahim");
        employees.setEmail("ikd@gmail.gn");
        employees.setPassword("passer123");

        //employeesRepository.save(employees);

    }
}
