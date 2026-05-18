package ems_backend.springboot.project.service;

import ems_backend.springboot.project.dto.EmployeeDto;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long employee);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employee, EmployeeDto updateEmployee);
    void deleteEmployee(Long employee);
}
