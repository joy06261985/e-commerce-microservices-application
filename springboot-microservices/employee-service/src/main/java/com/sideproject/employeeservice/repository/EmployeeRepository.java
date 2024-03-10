package com.sideproject.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
