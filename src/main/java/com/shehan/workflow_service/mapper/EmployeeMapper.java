package com.shehan.workflow_service.mapper;

import com.shehan.workflow_service.dto.EmployeeDto;
import com.shehan.workflow_service.model.Employee;

public class EmployeeMapper {


    //Map the Employee entity to EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }


    //Map the EmployeeDto into Employee entity
    public static  Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
