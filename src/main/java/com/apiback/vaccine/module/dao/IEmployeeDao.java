package com.apiback.vaccine.module.dao;


import java.util.List;

import com.apiback.vaccine.module.entity.Employee;
import com.apiback.vaccine.module.entity.Genstatus;
import com.apiback.vaccine.utils.IGenericRepo;

public interface IEmployeeDao extends IGenericRepo<Employee, Integer>{
	
	List<Employee> findByGenstatus(Genstatus status);

}