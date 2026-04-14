package com.shehan.workflow_service.service;

import com.shehan.workflow_service.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    //This method will retrieve an employee by their ID
    EmployeeDto getEmployeeById(long employeeId);
    //get all employees list data
    List<EmployeeDto> getAllEmployees();
}