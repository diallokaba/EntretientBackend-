package com.diallo.entretient.controller;

import com.diallo.entretient.entities.Employees;
import com.diallo.entretient.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "*")
@RequestMapping("/api/path1")
public class EmployeesController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping("/employees")
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employees employee = employeesRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employees")
    public Employees createEmployee(@Validated @RequestBody Employees employee) {
        return employeesRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employees employee = employeesRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not present for the id :: " + employeeId));

        employeesRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable(value = "id") Long employeeId, @Validated @RequestBody Employees employeeDetails) throws ResourceNotFoundException {
        Employees employee = employeesRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employee.setEmail(employeeDetails.getEmail());
        employee.setPassword(employeeDetails.getPassword());
        employee.setNom(employeeDetails.getNom());
        employee.setPrenom(employeeDetails.getPrenom());
        final Employees updatedEmployee = employeesRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

}
