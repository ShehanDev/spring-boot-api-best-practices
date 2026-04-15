package com.shehan.workflow_service.controller;
import com.shehan.workflow_service.dto.EmployeeDto;
import com.shehan.workflow_service.model.Employee;
import com.shehan.workflow_service.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Employee Management API", description = "API for managing employee data")
public class EmployeeController {


    private EmployeeService  employeeService;




    @Operation(summary = "Create a new employee", description = "Creates a new employee with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "employee created successfully",
                    content = @Content(schema = @Schema(implementation = EmployeeDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
    //This method will handle HTTP POST requests to create a new employee
    @PostMapping
    //The @RequestBody annotation indicates that the employee data
    // will be sent in the request body as JSON and will be deserialized into an EmployeeDto object.
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmplyee = employeeService.createEmployee(employeeDto);
        return  new  ResponseEntity<>(savedEmplyee, HttpStatus.CREATED);
    }



    @Operation(summary = "Get employee by ID", description = "Retrieves an employee by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found",
                    content = @Content(schema = @Schema(implementation = EmployeeDto.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content(schema = @Schema()))
    })
    //This method will handle HTTP GET requests to retrieve an employee by their ID
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);

    }


    @Operation(summary="Get all employees ",description = "Retrieves a list of all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully",
                    content = @Content(schema = @Schema(implementation = EmployeeDto.class)))
    })
    //Get all employees list
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
       List<EmployeeDto> employees =  employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    };


    @Operation(summary = "Update an existing employee", description = "Updates an existing employee with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully",
                    content = @Content(schema = @Schema(implementation = EmployeeDto.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content(schema = @Schema()))
    })
    //update Employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId ,@RequestBody EmployeeDto updatedEmpData){
        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeId,updatedEmpData);
        return ResponseEntity.ok(updatedEmployee);
    }

    @Operation(summary = "Delete an employee", description = "Deletes an employee by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(schema = @Schema()))
    })
    //Delete employee by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.DeleteEmployee(employeeId);
        return  ResponseEntity.ok("Emplyee Deleted Successfully!");
    };

}
