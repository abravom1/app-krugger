package com.apiback.vaccine.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiback.vaccine.module.dao.IEmployeeVaccineDao;
import com.apiback.vaccine.module.entity.EmployeeVaccine;
import com.apiback.vaccine.module.service.IEmployeeVaccine;
import com.apiback.vaccine.utils.CrudImpl;
import com.apiback.vaccine.utils.IGenericRepo;

@Service
public class EmployeevaccineImpl extends CrudImpl<EmployeeVaccine, Integer> implements IEmployeeVaccine{
	
	@Autowired
	private IEmployeeVaccineDao emplVacciDao;

	@Override
	protected IGenericRepo<EmployeeVaccine, Integer> getRepo() {
		return emplVacciDao;
	}

}
