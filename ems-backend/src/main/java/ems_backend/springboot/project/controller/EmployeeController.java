package ems_backend.springboot.project.controller;

import ems_backend.springboot.project.dto.EmployeeDto;
import ems_backend.springboot.project.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    
    // Building Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedemployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedemployeeDto, HttpStatus.CREATED);
    }
    // Build Get Employee by Id
    @GetMapping("{Id}")
    public ResponseEntity <EmployeeDto> getEmployee(@PathVariable("Id") Long employeeid) {
        EmployeeDto employeeDto = employeeService.getEmployee(employeeid);
        return ResponseEntity.ok(employeeDto);
    }
    // Build Get All Employee
    @GetMapping
    public  ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    // Build Update Employee REST API
    @PutMapping("{Id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("Id") Long employeeid,@RequestBody EmployeeDto updateEmployee) {
        EmployeeDto updatedemployeeDto = employeeService.updateEmployee(employeeid, updateEmployee);
        return ResponseEntity.ok(updatedemployeeDto);

    }
    // Build Delete Employee REST API
    @DeleteMapping("{Id}")
    public ResponseEntity<String>  deleteEmployee(@PathVariable("Id") Long employeeid) {
        employeeService.deleteEmployee(employeeid);
        return ResponseEntity.ok("Employee deleted Successfully");
    }
}
