package com.imaginnovate.example;


import org.springframework.data.jpa.repository.JpaRepository;

 
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
	
	
}