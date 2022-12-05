package com.apiback.vaccine.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apiback.vaccine.security.dao.IUsersDao;
import com.apiback.vaccine.security.entity.Role;
import com.apiback.vaccine.security.entity.Users;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private IUsersDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users objuser = userDao.findByUsername(username);
        
        if(objuser == null) {
        	throw new UsernameNotFoundException("User: " + username + " does not exist.");
        }//end if
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(Role role: objuser.getRole()) {
        	authorities.add(new SimpleGrantedAuthority(role.getName()));
        }//end for
        
        if(authorities.isEmpty()) {
        	throw new UsernameNotFoundException("User: " + username + " had no assigned roles!");
        }//end if
        
		return new User(
				objuser.getUsername(), 
				objuser.getPassword(), 
				true, //enabled
				true, //accountNonExpired
				true, //credentialsNonExpired
				true, //accountNonLocked 
				authorities);
		
	}
	
	@Transactional
	public Users save(Users userP) {
		Users user = userDao.save(userP);
		return user;
	}

}
