package com.apiback.vaccine.module.service;

import java.time.LocalDateTime;
import java.util.List;

import com.apiback.vaccine.module.dto.EmployeeDTO;
import com.apiback.vaccine.module.entity.Employee;
import com.apiback.vaccine.module.entity.Genstatus;
import com.apiback.vaccine.module.entity.TypeVaccine;
import com.apiback.vaccine.security.entity.Users;
import com.apiback.vaccine.utils.ICrud;

public interface IEmployee extends ICrud<Employee, Integer>{

	public Employee saveTransaccion(Employee map, Users user, String action) throws Exception;
	
	public List<EmployeeDTO> findByGenstatus(Genstatus status) throws Exception;
	
	public List<EmployeeDTO> findByTypeVaccine(TypeVaccine typevaccine) throws Exception;
	
	public List<EmployeeDTO> findByBetweenDate(LocalDateTime ini, LocalDateTime end) throws Exception;
	
	

}
