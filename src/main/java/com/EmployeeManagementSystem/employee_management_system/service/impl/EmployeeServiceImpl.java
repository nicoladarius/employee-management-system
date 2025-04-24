package com.EmployeeManagementSystem.employee_management_system.service.impl;

import com.EmployeeManagementSystem.employee_management_system.dto.EmployeeDto;
import com.EmployeeManagementSystem.employee_management_system.entity.Employee;
import com.EmployeeManagementSystem.employee_management_system.mapper.EmployeeMapper;
import com.EmployeeManagementSystem.employee_management_system.repository.EmployeeRepository;
import com.EmployeeManagementSystem.employee_management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
