package com.EmployeeManagementSystem.employee_management_system.service.impl;

import com.EmployeeManagementSystem.employee_management_system.dto.EmployeeDto;
import com.EmployeeManagementSystem.employee_management_system.entity.Employee;
import com.EmployeeManagementSystem.employee_management_system.exception.ResourceNotFoundException;
import com.EmployeeManagementSystem.employee_management_system.mapper.EmployeeMapper;
import com.EmployeeManagementSystem.employee_management_system.repository.EmployeeRepository;
import com.EmployeeManagementSystem.employee_management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee didn't exist with given id : " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List <Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }
}
