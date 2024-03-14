package com.imaginnovate.example;

import java.sql.Date;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
	@Data
	@Table(name = "Employee")
	public class Employee {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    int employeeID;
	    
	    @Column(name = "FirstName")
	    String FirstName;
	    
	    @Column(name = "LastName")
	    String LastName;
	    
	    @Column(name = "Gender")
	    char Gender;
	    
	    @Column(name = "DOB")
	    Date DOB;
	    
	    @Column(name = "Phone")
	    long Phone;
	    
	    @Column(name = "Address")
	    String Address;

	    
	    public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(int employeeID, String firstName, String lastName, char gender, Date dOB, long phone,
				String address) {
			super();
			this.employeeID = employeeID;
			FirstName = firstName;
			LastName = lastName;
			Gender = gender;
			DOB = dOB;
			Phone = phone;
			Address = address;
		}

		public int getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}

		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String firstName) {
			FirstName = firstName;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
		}

		public char getGender() {
			return Gender;
		}

		public void setGender(char gender) {
			Gender = gender;
		}

		public Date getDOB() {
			return DOB;
		}

		public void setDOB(Date dOB) {
			DOB = dOB;
		}

		public long getPhone() {
			return Phone;
		}

		public void setPhone(long phone) {
			Phone = phone;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

	}
