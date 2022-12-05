package com.apiback.vaccine.module.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apiback.vaccine.module.dao.IEmployeeDao;
import com.apiback.vaccine.module.dao.IEmployeeVaccineDao;
import com.apiback.vaccine.module.dto.EmployeeDTO;
import com.apiback.vaccine.module.entity.Employee;
import com.apiback.vaccine.module.entity.EmployeeUser;
import com.apiback.vaccine.module.entity.EmployeeVaccine;
import com.apiback.vaccine.module.entity.Genstatus;
import com.apiback.vaccine.module.entity.TypeVaccine;
import com.apiback.vaccine.module.service.IEmployee;
import com.apiback.vaccine.security.dao.IUsersDao;
import com.apiback.vaccine.security.entity.Users;
import com.apiback.vaccine.utils.CrudImpl;
import com.apiback.vaccine.utils.DataConfig;
import com.apiback.vaccine.utils.IGenericRepo;

@Service
public class EmployeeImpl extends CrudImpl<Employee, Integer> implements IEmployee {

	@Autowired
	private IEmployeeDao emplDao;
	
	@Autowired
	private IUsersDao userDao;
	
	@Autowired
	private IEmployeeVaccineDao emplvaccineDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	protected IGenericRepo<Employee, Integer> getRepo() {
		return emplDao;
	}
	
	@Transactional
	public Employee saveTransaccion(Employee empl, Users user, String action) throws Exception{
		
		
		if(empl.getGenstatus()!=null && empl.getGenstatus().getId() == DataConfig.id_status_vaccine && action.equals("U")) {
			
			if(empl.getEmployeevaccine()==null || empl.getEmployeevaccine().size() == 0) {
				throw new Exception("Debe ingresar la informacion requerida de la vacuna.");
			}//end if
			for (EmployeeVaccine val : empl.getEmployeevaccine()) {
				if(val.getTypevaccine()==null || val.getTypevaccine().getName()==null || val.getTypevaccine().getName().equals("")) {
					throw new Exception("Debe ingresar el tipo de vacuna.");
				}//end if
				if(val.getDate()==null) {
					throw new Exception("Debe ingresar la fecha de vacuna.");
				}//end if
				if(val.getNumberdoses()==null) {
					throw new Exception("Debe ingresar el numero de dosis.");
				}//end if
			}//end for
			
			empl.getEmployeevaccine().forEach(reg -> reg.setEmployee(empl));
		}//end if
		
		if(action!=null && action.equals("I")) {
			userDao.save(user);
			EmployeeUser empluser = new EmployeeUser();
			empluser.setEmployee(empl);
			empluser.setUser(user);
			empl.setEmployeeuser(empluser);
		}//end if
		
		
		emplDao.save(empl);
		
		return empl;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findByGenstatus(Genstatus status) throws Exception {
		List<EmployeeDTO> list = emplDao.findByGenstatus(status).stream().map(lst -> mapper.map(lst , EmployeeDTO.class)).collect(Collectors.toList());
		return list;
	}
	

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findByTypeVaccine(TypeVaccine typevaccine) throws Exception {
		List<EmployeeVaccine> list = emplvaccineDao.findBytypevaccine(typevaccine);
		List<EmployeeDTO> listResult = list.stream().map(lst -> mapper.map(lst.getEmployee(), EmployeeDTO.class)).collect(Collectors.toList());
		return listResult;
	}

	@Override
	public List<EmployeeDTO> findByBetweenDate(LocalDateTime ini, LocalDateTime end) throws Exception {
		List<EmployeeVaccine> list = emplvaccineDao.findByBetweenDate(ini, end);
		List<EmployeeDTO> listResult = list.stream().map(lst -> mapper.map(lst.getEmployee(), EmployeeDTO.class)).collect(Collectors.toList());
		return listResult;
	}
	
	
}