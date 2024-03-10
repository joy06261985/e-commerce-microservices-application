package com.sideproject.departmentservice.service.impl;

import org.springframework.stereotype.Service;

import com.sideproject.departmentservice.dto.DepartmentDto;
import com.sideproject.departmentservice.entity.Department;
import com.sideproject.departmentservice.repository.DepartmentRepository;
import com.sideproject.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartmentDto(DepartmentDto departmentDto) {
        // convert department dto to department jpa entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDescription(),
                departmentDto.getCode());

        Department saveDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                saveDepartment.getId(),
                saveDepartment.getName(),
                saveDepartment.getDescription(),
                saveDepartment.getCode());

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getByCode(String code) {
        Department department = departmentRepository.findByCode(code);
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDescription(),
                department.getCode());
        return departmentDto;
    }
}
