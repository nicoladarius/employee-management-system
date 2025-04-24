package com.EmployeeManagementSystem.employee_management_system.repository;

import com.EmployeeManagementSystem.employee_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
