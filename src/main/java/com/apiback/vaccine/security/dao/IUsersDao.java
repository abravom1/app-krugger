package com.apiback.vaccine.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiback.vaccine.security.entity.Users;

public interface IUsersDao extends JpaRepository<Users, String>{
	
	public Users findByUsername(String username);

}