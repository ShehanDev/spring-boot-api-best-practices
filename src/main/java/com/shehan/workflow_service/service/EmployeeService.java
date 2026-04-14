package com.shehan.workflow_service.service;

import com.shehan.workflow_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    //This method will retrieve an employee by their ID
    EmployeeDto getEmployeeById(long employeeId);
}
