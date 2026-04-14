package com.shehan.workflow_service.service.impl;

import com.shehan.workflow_service.dto.EmployeeDto;
import com.shehan.workflow_service.exception.ResourceNotFoundException;
import com.shehan.workflow_service.mapper.EmployeeMapper;
import com.shehan.workflow_service.model.Employee;
import com.shehan.workflow_service.repository.EmployeeRepository;
import com.shehan.workflow_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


    //This method will retrieve an employee by their ID
    @Override
    public EmployeeDto getEmployeeById(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee Not exist with given id :"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().
                map((employee -> EmployeeMapper.mapToEmployeeDto(employee))).
                collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        //find the employee
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(()->
                        new ResourceNotFoundException("Employee Not exist with given id :"+employeeId));

        //updated with values
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getFirstName());
        employee.setEmail(updatedEmployee.getEmail());
       //save method perform both save and update operation
        //check object and is contain the id -> update operation
        // if not insert operation
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void DeleteEmployee(Long employeeId) {
        //find Employee
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Not exist with given id :"+employeeId));
        employeeRepository.deleteById(employeeId);
    }


}