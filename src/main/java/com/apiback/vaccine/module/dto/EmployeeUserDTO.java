package com.apiback.vaccine.module.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class EmployeeUserDTO {
	
	@JsonBackReference
	private EmployeeDTO employee;
	private UsersDTO user;

	public EmployeeUserDTO() {

	}

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	public UsersDTO getUser() {
		return user;
	}

	public void setUser(UsersDTO user) {
		this.user = user;
	}

}
