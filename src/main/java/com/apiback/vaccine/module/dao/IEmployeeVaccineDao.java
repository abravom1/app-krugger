package com.apiback.vaccine.module.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.apiback.vaccine.module.entity.EmployeeVaccine;
import com.apiback.vaccine.module.entity.TypeVaccine;
import com.apiback.vaccine.utils.IGenericRepo;

public interface IEmployeeVaccineDao extends IGenericRepo<EmployeeVaccine, Integer>{
	
	List<EmployeeVaccine> findBytypevaccine(TypeVaccine typevaccine);
	
	@Query("from EmployeeVaccine a where a.date BETWEEN :ini AND :end")
	List<EmployeeVaccine> findByBetweenDate(LocalDateTime ini, LocalDateTime end);

}
