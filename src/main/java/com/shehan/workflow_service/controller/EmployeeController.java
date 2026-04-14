package com.shehan.workflow_service.controller;
import com.shehan.workflow_service.dto.EmployeeDto;
import com.shehan.workflow_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
//This annotation indicates that this class is a REST controller,
// which means it will handle HTTP requests and return responses in a RESTful manner.
@RestController
//Base URL for all endpoints in this controller
@RequestMapping("v1/api/employees")
public class EmployeeController {


    private EmployeeService  employeeService;

    //This method will handle HTTP POST requests to create a new employee
    @PostMapping
    //
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmplyee = employeeService.createEmployee(employeeDto);
        return  new  ResponseEntity<>(savedEmplyee, HttpStatus.CREATED);
    }



    //This method will handle HTTP GET requests to retrieve an employee by their ID
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);

    }

    //Get all employees list
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
       List<EmployeeDto> employees =  employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    };


}
