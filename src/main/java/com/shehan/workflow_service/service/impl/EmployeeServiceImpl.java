package com.shehan.workflow_service.service.impl;

import com.shehan.workflow_service.dto.EmployeeDto;
import com.shehan.workflow_service.mapper.EmployeeMapper;
import com.shehan.workflow_service.model.Employee;
import com.shehan.workflow_service.repository.EmployeeRepository;
import com.shehan.workflow_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//annotation tells spring container to create spring been for this class and manage its lifecycle
@Service

//annotation help to generate constructor with all the fields as parameters,
// which is useful for dependency injection(lombok)
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    //Dependency injection
    // inject the employee repository to perform database operations
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Map the EmployeeDto to Employee entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        // Save the employee entity to the database
        Employee savedEmployee = employeeRepository.save(employee);
        //return the saved employee as EmployeeDto
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
