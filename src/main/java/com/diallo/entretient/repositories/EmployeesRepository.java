package com.diallo.entretient.repositories;

import com.diallo.entretient.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}
