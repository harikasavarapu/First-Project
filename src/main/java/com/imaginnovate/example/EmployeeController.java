package com.imaginnovate.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employeeRepo;
    
	//localhost:8080/employee
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	//localhost:8080/addEmployee
	@PostMapping("/addEmployee")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
	    return employeeRepo.save(employee);
	}
	
	//localhost:8080/deleteEmployee/{2}
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int employeeID)
	        throws ResourceNotFoundException {
	    Employee employee = employeeRepo.findById(employeeID)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeID));
	    employeeRepo.deleteById(employeeID); // Use employeeID instead of employee
	    return "Record deleted Successfully";
	}
	
	//localhost:8080/updateEmployee/{2}
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int employeeID,@RequestBody Employee employee) {
        Employee updateEmployee = employeeRepo.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + employeeID));

        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setDOB(employee.getDOB());
        updateEmployee.setGender(employee.getGender());
        updateEmployee.setPhone(employee.getPhone());
        updateEmployee.setAddress(employee.getAddress());

        employeeRepo.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }
	
	//localhost:8080/updatepartiallyemployee/{2}
	@PatchMapping("/updatepartiallyemployee/{id}")
	   public ResponseEntity<Employee> updateUserPartially(@PathVariable(value = "id") int employeeID, @Validated @RequestBody Employee employeeDetails) 
			   throws ResourceNotFoundException {
	        Employee employee = employeeRepo.findById(employeeID)
	         .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ employeeID));
	       employee.setAddress(employeeDetails.getAddress());
	       employee.setPhone(employeeDetails.getPhone());
	       final Employee updatedEmployee = employeeRepo.save(employee);
	       return ResponseEntity.ok(updatedEmployee);
	  }
	
	}
