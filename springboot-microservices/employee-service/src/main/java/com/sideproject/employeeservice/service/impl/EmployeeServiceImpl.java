package com.sideproject.employeeservice.service.impl;

// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.web.reactive.function.client.WebClient;

import com.sideproject.employeeservice.dto.APIResponseDto;
import com.sideproject.employeeservice.dto.DepartmentDto;
import com.sideproject.employeeservice.dto.EmployeeDto;
import com.sideproject.employeeservice.entity.Employee;
import com.sideproject.employeeservice.repository.EmployeeRepository;
import com.sideproject.employeeservice.service.APIClient;
import com.sideproject.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

        private EmployeeRepository employeeRepository;
        // private RestTemplate restTemplate;
        // private WebClient webClient;
        private APIClient apiClient;

        @Override
        public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
                Employee employee = new Employee(
                                employeeDto.getId(),
                                employeeDto.getFirst_name(),
                                employeeDto.getLast_name(),
                                employeeDto.getEmail(),
                                employeeDto.getCode());

                Employee saveEmployee = employeeRepository.save(employee);

                EmployeeDto saveEmployeeDto = new EmployeeDto(
                                saveEmployee.getId(),
                                saveEmployee.getFirst_name(),
                                saveEmployee.getLast_name(),
                                saveEmployee.getEmail(),
                                saveEmployee.getCode());

                return saveEmployeeDto;
        }

        @Override
        public APIResponseDto getEmployeeById(Long employeeId) {
                Employee employee = employeeRepository.findById(employeeId).get();

                // // RestTemplate
                // //http://localhost:5555/api/departments/IT001
                // ResponseEntity<DepartmentDto> responseEntity = restTemplate
                // .getForEntity("http://localhost:5555/api/departments/" + employee.getCode(),
                // DepartmentDto.class);

                // DepartmentDto departmentDto = responseEntity.getBody();

                // // WebClient
                // DepartmentDto departmentDto = webClient.get()
                // .uri("http://localhost:5555/api/departments/" + employee.getCode())
                // .retrieve()
                // .bodyToMono(DepartmentDto.class)
                // .block();

                DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getCode());

                EmployeeDto employeeDto = new EmployeeDto(
                                employee.getId(),
                                employee.getFirst_name(),
                                employee.getLast_name(),
                                employee.getEmail(),
                                employee.getCode());

                APIResponseDto apiResponseDto = new APIResponseDto();
                apiResponseDto.setEmployee(employeeDto);
                apiResponseDto.setDepartment(departmentDto);

                return apiResponseDto;
        }
}
