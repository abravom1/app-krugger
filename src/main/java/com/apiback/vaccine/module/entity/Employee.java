package com.apiback.vaccine.module.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String dni;

	@Column(nullable = false)
	private String names;

	@Column(nullable = false)
	private String surnames;

	@Column(nullable = false)
	private String email;

	@OneToOne
	@JoinColumn(name = "id_status", referencedColumnName = "id", columnDefinition = "int2", foreignKey = @ForeignKey(name = "FK_GENESTATUS"))
	private Genstatus genstatus;

	private LocalDateTime birthdate;

	private String address;

	private String phone;

	@OneToMany(mappedBy = "employee", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<EmployeeVaccine> employeevaccine;

	@OneToOne(mappedBy = "user", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private EmployeeUser employeeuser;

	public Employee() {

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

	public Genstatus getGenstatus() {
		return genstatus;
	}

	public void setGenstatus(Genstatus genstatus) {
		this.genstatus = genstatus;
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

	public List<EmployeeVaccine> getEmployeevaccine() {
		return employeevaccine;
	}

	public void setEmployeevaccine(List<EmployeeVaccine> employeevaccine) {
		this.employeevaccine = employeevaccine;
	}

	public EmployeeUser getEmployeeuser() {
		return employeeuser;
	}

	public void setEmployeeuser(EmployeeUser employeeuser) {
		this.employeeuser = employeeuser;
	}

}
