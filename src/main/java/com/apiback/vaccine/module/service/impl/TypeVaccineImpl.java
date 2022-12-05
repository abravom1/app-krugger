package com.apiback.vaccine.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiback.vaccine.module.dao.ITypeVaccineDao;
import com.apiback.vaccine.module.entity.TypeVaccine;
import com.apiback.vaccine.module.service.ITypevaccine;
import com.apiback.vaccine.utils.CrudImpl;
import com.apiback.vaccine.utils.IGenericRepo;

@Service
public class TypeVaccineImpl extends CrudImpl<TypeVaccine, Integer> implements ITypevaccine {

	@Autowired
	private ITypeVaccineDao typevaccineDao;
	
	@Override
	protected IGenericRepo<TypeVaccine, Integer> getRepo() {
		return typevaccineDao;
	}

}
