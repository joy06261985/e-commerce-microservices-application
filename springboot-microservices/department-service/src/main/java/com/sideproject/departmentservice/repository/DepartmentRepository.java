package com.sideproject.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByCode(String code);
}
