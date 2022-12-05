package com.apiback.vaccine.module.entity;

import java.time.LocalDateTime;

import javax.persistence.ForeignKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EmployeeVaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idemployeevacine;
	
	@ManyToOne
	@JoinColumn(name = "id_employee", foreignKey = @ForeignKey(name = "FK_EMPLOYEE"))
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "id_typevaccine", foreignKey = @ForeignKey(name = "FK_TYPEVACCINE"))
	private TypeVaccine typevaccine;
	
	private LocalDateTime date;
	
	private Integer numberdoses;

	public EmployeeVaccine() {
		
	}

	

	public Integer getIdemployeevacine() {
		return idemployeevacine;
	}



	public void setIdemployeevacine(Integer idemployeevacine) {
		this.idemployeevacine = idemployeevacine;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public TypeVaccine getTypevaccine() {
		return typevaccine;
	}



	public void setTypevaccine(TypeVaccine typevaccine) {
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
