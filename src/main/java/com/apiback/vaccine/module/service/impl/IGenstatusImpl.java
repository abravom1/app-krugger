package com.apiback.vaccine.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiback.vaccine.module.dao.IGenstatusDao;
import com.apiback.vaccine.module.entity.Genstatus;
import com.apiback.vaccine.module.service.IGenstatus;
import com.apiback.vaccine.utils.CrudImpl;
import com.apiback.vaccine.utils.IGenericRepo;

@Service
public class IGenstatusImpl extends CrudImpl<Genstatus, Integer> implements IGenstatus {
	
	@Autowired
	private IGenstatusDao statusDao;

	@Override
	protected IGenericRepo<Genstatus, Integer> getRepo() {
		return statusDao;
	}

}
