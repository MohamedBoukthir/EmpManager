package com.emp.empmanager.controller;

import com.emp.empmanager.model.Employee;
import com.emp.empmanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService empService;
    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    // Get all Employee
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmp() {
        List<Employee> employees = empService.findAllEmp();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Get One Employee By id
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long id) {
        Employee employee = empService.findEmpById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Add New Employee
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
        Employee newEmployee = empService.addEmp(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    // update Employee
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee) {
        Employee updatedEmployee = empService.updateEmp(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // delete Employee By id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmpById(@PathVariable("id") Long id) {
        empService.deleteEmpById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
