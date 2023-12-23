package com.emp.empmanager.service;

import com.emp.empmanager.exception.UserNotFoundException;
import com.emp.empmanager.model.Employee;
import com.emp.empmanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo empRepo;

    @Autowired
    public EmployeeService(EmployeeRepo empRepo) {
        this.empRepo = empRepo;
    }

    // generate a Employee Code
    public Employee addEmp(Employee emp){
        emp.setEmployeeCode(UUID.randomUUID().toString());
        return empRepo.save(emp);
    }

    // GetAll Employee
    public List<Employee> findAllEmp(){
        return empRepo.findAll();
    }

    // update Employee
    public Employee updateEmp(Employee emp){
        return empRepo.save(emp);
    }

    // Find Employee By id
    public Employee findEmpById(Long id){
        return empRepo.findEmpById(id)
                /* iff don't exist show exception */
                .orElseThrow(() -> new UserNotFoundException("User By ID : " + id + " Not Found"));
    }

    // delete Employee By id
    public void deleteEmpById(Long id){
        empRepo.deleteEmpById(id);
    }

}
