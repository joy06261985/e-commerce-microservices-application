package com.sideproject.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIResponseDto {
    private EmployeeDto employee;
    private DepartmentDto department;
}
