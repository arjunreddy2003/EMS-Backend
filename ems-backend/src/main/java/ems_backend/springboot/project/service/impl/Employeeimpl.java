package ems_backend.springboot.project.service.impl;

import ems_backend.springboot.project.Employeemapper.mapper;
import ems_backend.springboot.project.dto.EmployeeDto;
import ems_backend.springboot.project.entity.Employee;
import ems_backend.springboot.project.exception.ResourceNotfound;
import ems_backend.springboot.project.repository.EmployeeRepository;
import ems_backend.springboot.project.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Employeeimpl implements EmployeeService {

private EmployeeRepository employeeRepository;
    @PostMapping
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= mapper.maptoEmployee(employeeDto);
        Employee savedemp=employeeRepository.save(employee);
        return  mapper.maptoEmployeeDto(savedemp);

    }

    @Override
    public EmployeeDto getEmployee(Long employeeid) {
        Employee employee=employeeRepository.findById(employeeid)
                .orElseThrow(() ->
                        new ResourceNotfound("Employee not found with id " + employeeid));
        return mapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map((employee -> mapper.maptoEmployeeDto(employee)))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeid, EmployeeDto updateEmployee) {
       Employee employee= employeeRepository.findById(employeeid).orElseThrow(
                () -> new ResourceNotfound("Employee not found with id " + employeeid)
        );
       employee.setFirstName(updateEmployee.getFirstName());
       employee.setLastName(updateEmployee.getLastName());
       employee.setEmail(updateEmployee.getEmail());

       Employee updateemp=employeeRepository.save(employee);
        return mapper.maptoEmployeeDto(updateemp);
    }

    @Override
    public void deleteEmployee(Long employee) {
        Employee employee1=employeeRepository.findById(employee).orElseThrow(
                () -> new ResourceNotfound("Employee not found with id " + employee)
        );
        employeeRepository.delete(employee1);
    }
}
