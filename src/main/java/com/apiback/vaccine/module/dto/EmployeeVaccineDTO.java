package com.apiback.vaccine.module.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmployeeVaccineDTO {

	@JsonIgnore
	private EmployeeDTO employee;
	
	@NotNull
	private TypeVaccineDTO typevaccine;
	
	@NotNull(message = "{date.null}")
	@NotEmpty(message = "{date.empty}")
	private LocalDateTime date;
	
	@NotNull(message = "{numberdoses.null}")
	@NotEmpty(message = "{numberdoses.empty}")
	private Integer numberdoses;

	public EmployeeVaccineDTO() {

	}

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	public TypeVaccineDTO getTypevaccine() {
		return typevaccine;
	}

	public void setTypevaccine(TypeVaccineDTO typevaccine) {
		this.typevaccine = typevaccine;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getNumberdoses() {
		return numberdoses;
	}

	public void setNumberdoses(Integer numberdoses) {
		this.numberdoses = numberdoses;
	}

}
