package com.emp.empmanager.repo;

import com.emp.empmanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    void deleteEmpById(Long id);
    Optional<Employee> findEmpById(Long id);

}
