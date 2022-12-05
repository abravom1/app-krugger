package com.apiback.vaccine.module.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.apiback.vaccine.security.entity.Users;

@Entity
public class EmployeeUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idemployeeuser;

	@ManyToOne
	@JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLOYEE"))
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_USERS"))
	private Users user;

	public EmployeeUser() {

	}

	public Integer getIdemployeeuser() {
		return idemployeeuser;
	}

	public void setIdemployeeuser(Integer idemployeeuser) {
		this.idemployeeuser = idemployeeuser;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
