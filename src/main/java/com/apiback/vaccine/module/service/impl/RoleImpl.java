package com.apiback.vaccine.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiback.vaccine.module.dao.IRoleDao;
import com.apiback.vaccine.module.service.IRole;
import com.apiback.vaccine.security.entity.Role;
import com.apiback.vaccine.utils.CrudImpl;
import com.apiback.vaccine.utils.IGenericRepo;

@Service
public class RoleImpl extends CrudImpl<Role, Integer> implements IRole {

	@Autowired
	private IRoleDao rolDao;

	@Override
	protected IGenericRepo<Role, Integer> getRepo() {
		return rolDao;
	}
}