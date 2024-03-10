package com.sideproject.employeeservice.service;

import com.sideproject.employeeservice.dto.APIResponseDto;
import com.sideproject.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
