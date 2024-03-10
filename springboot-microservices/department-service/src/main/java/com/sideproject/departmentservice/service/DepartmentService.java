package com.sideproject.departmentservice.service;

import com.sideproject.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartmentDto(DepartmentDto departmentDto);

    DepartmentDto getByCode(String code);
}
