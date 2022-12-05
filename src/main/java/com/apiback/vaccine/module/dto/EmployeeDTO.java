package com.apiback.vaccine.module.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDTO {

	private Integer id;

	@NotNull(message = "{dni.null}")
	@NotEmpty(message = "{dni.empty}")
	@Size(min = 10, message = "{dni.size}")
	@Pattern(regexp = "[0-9]+", message = "{dni.content}")
	private String dni;

	@NotNull(message = "{names.null}")
	@NotEmpty(message = "{names.empty}")
	@Pattern(regexp = "[A-Z a-z]+", message = "{names.content}")
	private String names;

	@NotNull(message = "{surnames.null}")
	@NotEmpty(message = "{surnames.empty}")
	@Pattern(regexp = "[A-Z a-z]+", message = "{surnames.content}")
	private String surnames;

	@NotNull(message = "{email.null}")
	@NotEmpty(message = "{email.empty}")
	@Email
	private String email;

	/* no required */
	private LocalDateTime birthdate;
	private String address;
	private String phone;
	private GenstatusDTO genstatus;
	private List<EmployeeVaccineDTO> employeevaccine;
	private EmployeeUserDTO employeeuser;

	public EmployeeDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDateTime birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public GenstatusDTO getGenstatus() {
		return genstatus;
	}

	public void setGenstatus(GenstatusDTO genstatus) {
		this.genstatus = genstatus;
	}

	public List<EmployeeVaccineDTO> getEmployeevaccine() {
		return employeevaccine;
	}

	public void setEmployeevaccine(List<EmployeeVaccineDTO> employeevaccine) {
		this.employeevaccine = employeevaccine;
	}

	public EmployeeUserDTO getEmployeeuser() {
		return employeeuser;
	}

	public void setEmployeeuser(EmployeeUserDTO employeeuser) {
		this.employeeuser = employeeuser;
	}

}
